public class TestFireBall {

    public static void main(String[] args) {
        new TestFireBall();
    }

    public TestFireBall() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new FireBallPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class FireBallPane extends JLayeredPane {

        private JLabel character;
        private List<JLabel> fireBalls;
        private ImageIcon icoFireBall;
        private Timer timer;
        private Timer coolOffTimer;
        private int vX = 12;
        private boolean coolOff = false;

        public FireBallPane() {
            fireBalls = new ArrayList<JLabel>(25);

            ImageIcon icoCharacter = null;
            ImageIcon fireBall = null;

            try {
                icoCharacter = new ImageIcon(ImageIO.read(getClass().getResource("/BlackMage.png")));
                icoFireBall = new ImageIcon(ImageIO.read(getClass().getResource("/FireBall.png")));
            } catch (Exception e) {
                e.printStackTrace();
            }

            character = new JLabel(icoCharacter);

            add(character);

            setFocusable(true);
            requestFocusInWindow();

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "fire");
            ActionMap am = getActionMap();
            am.put("fire", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!coolOff) {
                        coolOff = true;
                        JLabel fireBall = createFireBall();
                        fireBalls.add(fireBall);
                        if (!timer.isRunning()) {
                            timer.start();
                        }
                        coolOffTimer.restart();
                    }
                }
            });

            timer = new Timer(125, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (fireBalls.size() > 0) {
                        JLabel[] balls = fireBalls.toArray(new JLabel[fireBalls.size()]);
                        for (JLabel fireBall : balls) {
                            if (fireBall.getParent() == null) {
                                add(fireBall);
                            }
                            Point p = fireBall.getLocation();
                            p.x += vX;
                            if (p.x + fireBall.getWidth() >= getWidth()) {
                                remove(fireBall);
                                fireBalls.remove(fireBall);
                            } else {
                                fireBall.setLocation(p);
                            }
                            repaint();
                        }
                    } else {
                        timer.stop();
                    }
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);

            coolOffTimer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    coolOff = false;
                }
            });
            coolOffTimer.setRepeats(false);
            coolOffTimer.setCoalesce(true);
        }

        protected JLabel createFireBall() {
            JLabel fireBall = new JLabel(icoFireBall);

            fireBall.setSize(fireBall.getPreferredSize());
            int x = character.getX() + character.getWidth();
            int y = character.getY() + ((character.getHeight() - fireBall.getHeight()) / 2);
            fireBall.setLocation(x, y);

            return fireBall;
        }

        @Override
        public void invalidate() {
            super.invalidate();

            character.setSize(character.getPreferredSize());
            int height = getHeight();
            int y = (height - character.getHeight()) / 2;
            character.setLocation(0, y);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }
    }
}