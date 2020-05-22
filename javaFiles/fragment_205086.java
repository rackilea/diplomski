public class ASD extends JPanel implements ActionListener {

        private Timer tm;

        public ASD() {
            addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        //case KeyEvent.VK_DOWN: y += 10;break;
                        //case KeyEvent.VK_UP: y -= 10; break;
                        case KeyEvent.VK_LEFT:
                            x -= 10;
                            break;
                        case KeyEvent.VK_RIGHT:
                            x += 10;
                            break;
                    }
                    repaint();
                }
            });

            tm = new Timer(200, this);
            tm.setRepeats(true);
            tm.start();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            y = y + 10;
            repaint();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.BLACK);

            g.setColor(Color.WHITE);
            g.fillRect(x, y, 30, 30);
        }
    }