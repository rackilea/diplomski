public class Game {

    public static void main(String[] args) {

        final JFrame frame = new JFrame("Test");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new GamePanel());
        frame.setVisible(true);

    }

    @SuppressWarnings("serial")
    private static class GamePanel extends JPanel {

        private int x = 0;
        private int y = 0;
        private boolean clicked = false;

        public GamePanel() {
            super();
            setSize(500, 500);
            setBackground(Color.BLACK);
            addMouseListener(new MouseListenerImpl());
            addMouseMotionListener(new MouseMotionListenerImpl());
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.GREEN);
            g.drawRect(150, 75, 200, 100);
            g.setColor(Color.ORANGE);
            g.drawString("Play", 239, 123);

            if (x > 150 && y > 75 && x < 350 && y < 175) {
                g.drawRect(150, 75, 200, 100);
                if (clicked) {
                    g.fillRect(10, 10, 100, 100);
                }
            }
        }

        private class MouseListenerImpl extends MouseAdapter {
            @Override
            public void mouseClicked(MouseEvent e) {
                clicked = !clicked;
                repaint();
            }
        }

        private class MouseMotionListenerImpl extends MouseMotionAdapter {
            @Override
            public void mouseMoved(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();
            }
        }
    }
}