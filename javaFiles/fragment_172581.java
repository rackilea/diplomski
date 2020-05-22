public class TextOverImage {

    public static void main(String[] args) {
        new TextOverImage();
    }

    public TextOverImage() {
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

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new ImagePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class ImagePane extends JLayeredPane {

        private BufferedImage background;

        public ImagePane() {
            setFocusable(true);
            try {
                background = ImageIO.read(new File("Your/image/here"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Component focusOwner = FocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
                    if (!(focusOwner instanceof OverlayEditor)) {
                        OverlayEditor field = new OverlayEditor();
                        field.setLocation(e.getPoint());
                        add(field);
                        invalidate();
                        repaint();
                        field.requestFocusInWindow();
                    } else {
                        requestFocusInWindow();
                    }
                }

            });
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancel");
            am.put("cancel", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Component focusOwner = FocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
                    if (focusOwner instanceof OverlayEditor) {
                        remove(focusOwner);
                        invalidate();
                        repaint();
                    }
                }

            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (background != null) {
                int x = (getWidth() - background.getWidth());
                int y = (getHeight() - background.getHeight());
                g.drawImage(background, x, y, this);
            }
        }

    }

    public class OverlayEditor extends JTextArea {

        public OverlayEditor() {
            super(1, 10);
            setBorder(null);
            setForeground(Color.WHITE);
            setOpaque(false);
            setSize(getPreferredSize());

            getDocument().addDocumentListener(new DocumentListener() {
                public void update() {
                    setSize(getPreferredSize());
                }

                @Override
                public void insertUpdate(DocumentEvent e) {
                    update();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    update();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    update();
                }

            });

            addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    setBorder(new LineBorder(Color.WHITE));
                    repaint();
                }

                @Override
                public void focusLost(FocusEvent e) {
                    setBorder(null);
                    repaint();
                }

            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (hasFocus()) {
                g2d.setColor(new Color(0, 0, 0, 32));
                g2d.fill(new Rectangle(getWidth(), getHeight()));
            }
            g2d.dispose();
        }

    }

}