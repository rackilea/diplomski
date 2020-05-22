public class TestGame {

    public static void main(String[] args) throws InterruptedException {
        new TestGame();
    }

    public TestGame() {
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

                Game game = new Game();

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(game);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class GameThread extends Thread {

        private Game game;

        public GameThread(Game game) {
            setDaemon(false);
            this.game = game;
        }

        @Override
        public void run() {
            while (true) {
                game.move();
                try {
                    long startedAt = System.currentTimeMillis();
                    SwingUtilities.invokeAndWait(new Runnable() {
                        @Override
                        public void run() {
                            game.repaint();
                        }
                    });
                    long completedAt = System.currentTimeMillis();
                    long sleepFor = 30 - (completedAt - startedAt);
                    if (sleepFor < 0) {
                        sleepFor = 30;
                    }
                    Thread.sleep(sleepFor);
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }

        }
    }

    public class Game extends JPanel {

        Square square = new Square(this);
        Ground ground = new Ground(this);

        public Game() {
//            addKeyListener(new KeyListener() {
//                @Override
//                public void keyTyped(KeyEvent e) {
//                }
//
//                @Override
//                public void keyReleased(KeyEvent e) {
//                    square.keyReleased(e);
//                }
//
//                @Override
//                public void keyPressed(KeyEvent e) {
//                    square.keyPressed(e);
//                }
//            });
            setFocusable(true);

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "press-left");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "press-right");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "press-down");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "press-up");

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "release-left");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "release-right");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "release-down");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "release-up");    

            am.put("press-left", new PressLeftAction(square));
            am.put("press-right", new PressRightAction(square));
            am.put("press-down", new PressDownAction(square));
            am.put("press-up", new PressUpAction(square));

            am.put("release-left", new ReleaseLeftAction(square));
            am.put("release-right", new ReleaseRightAction(square));
            am.put("release-down", new ReleaseDownAction(square));
            am.put("release-up", new ReleaseUpAction(square));

            new GameThread(this).start();

//        public void keyReleased(KeyEvent e) {
//
//
//
//            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//                xa = 0;
//            }
//
//            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//                xa = 0;
//            }
//            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//                d = 60;
//            }
//
//            if (e.getKeyCode() == KeyEvent.VK_UP);
//        }
//
//        public void keyPressed(KeyEvent e) {
//// TODO Auto-generated method stub
//            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//                xa = xa - 3;
//            }
//
//            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//                xa = xa + 3;
//            }
//
//            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//                d = 30;
//            }
//
//            if (e.getKeyCode() == KeyEvent.VK_UP) {
//                ya -= 60;
//            }
//
//
//
//
//
//        }
        }

        public void move() {
            square.move();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        // Don't override paint, use paintComponent instead
//        @Override
//        public void paint(Graphics g) {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            square.paint(g2d);
            ground.paint(g2d);
            g2d.dispose();
        }
    }

    public class Square {

        Square square;
        private int x, xa;
//        static int y;
        private int y;
        private int ya;
        private Game game;
//        public static int fistX, fistY;
        private int fistX, fistY;
//        static int d = 60;
        private int d = 60;
        private int wide;
        private boolean onGround;

        public Square(Game game) {
            this.game = game;
            x = 100;
            y = 100;
            xa = 0;
            ya = 0;
            onGround = false;
            wide = game.getWidth();
        }

        public void move() {

            y += ya;
            x += xa;

            if (x < 0) {
                x = 0;
            } else if (x + 30 > game.getWidth()) {
                x = game.getWidth() - 30;
            }

            if (y < 0) {
                y = 0;
            } else if (collision()) {
                onGround = true;
                y = game.ground.getBounds().y - d;
            }

//            if (x + xa > 0 && x + xa < game.getWidth() - 30) {
//                x = x + xa;
//            }
//
//            if (y + ya > 0 && y + ya < game.getHeight() - 60) {
//                // This was never going to do anything, look at the
//                // end of the line...the `;` is going to prevent the
//                // statemt ya += 10 from begin called within the loop
////                for (int i = 12; i < 0; i--);
//                for (int i = 12; i < 0; i--) {
//                    ya += 10;
//                }
//                y = y + ya;
//            }
//            if (collision()) {
//                y -= 10;
//                onGround = true;
//
//            }
//
//            y += 10;

        }

        public void paint(Graphics2D g) {
            g.setColor(Color.RED);
            System.out.println(x + "x" + (y - d));
            g.fillRoundRect(x, y, 30, d, 10, 10);
        }

        private boolean collision() {
            return game.ground.getBounds().intersects(getBounds());
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, 30, 60);
        }
    }

    public class Ground {

        private Game game;

        public Ground(Game game) {
            this.game = game;
        }

        public void paint(Graphics2D g) {
            g.setColor(Color.BLACK);
            g.fillRect(0, game.getHeight() - 30, game.getWidth(), 30);
        }

        public Rectangle getBounds() {
            return new Rectangle(0, game.getHeight() - 30, game.getWidth(), 30);
        }
    }

    public abstract class AbstractSquareAction extends AbstractAction {

        private Square square;

        public AbstractSquareAction(Square square) {
            this.square = square;
        }

        public Square getSquare() {
            return square;
        }

    }

    public class PressLeftAction extends AbstractSquareAction {

        public PressLeftAction(Square square) {
            super(square);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getSquare().xa = -3;
            System.out.println("pressLeft");
        }

    }

    public class PressRightAction extends AbstractSquareAction {

        public PressRightAction(Square square) {
            super(square);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getSquare().xa = 3;
        }

    }

    public class PressDownAction extends AbstractSquareAction {

        public PressDownAction(Square square) {
            super(square);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getSquare().ya = 30;
        }

    }

    public class PressUpAction extends AbstractSquareAction {

        public PressUpAction(Square square) {
            super(square);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getSquare().ya -= 30;
        }

    }

    public class ReleaseLeftAction extends AbstractSquareAction {

        public ReleaseLeftAction(Square square) {
            super(square);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getSquare().xa = 0;
        }

    }

    public class ReleaseRightAction extends AbstractSquareAction {

        public ReleaseRightAction(Square square) {
            super(square);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getSquare().xa = 0;
        }

    }

    public class ReleaseDownAction extends AbstractSquareAction {

        public ReleaseDownAction(Square square) {
            super(square);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getSquare().ya = 0;
        }

    }

    public class ReleaseUpAction extends AbstractSquareAction {

        public ReleaseUpAction(Square square) {
            super(square);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getSquare().ya = 0;
        }

    }

}