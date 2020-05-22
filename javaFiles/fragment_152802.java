public class CenterOfFrame {

    public static void main(String[] args) {
        new CenterOfFrame();
    }

    public CenterOfFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                new BadFrame().setVisible(true);

                JFrame goodFrame = new JFrame();
                goodFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                goodFrame.setContentPane(new PaintablePane());
                goodFrame.pack();
                goodFrame.setLocationRelativeTo(null);
                goodFrame.setVisible(true);

            }
        });
    }

    public class BadFrame extends JFrame {

        public BadFrame() {
            setSize(800, 400);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            paintTest(g, getWidth() - 1, getHeight() - 1);
        }
    }

    public void paintTest(Graphics g, int width, int height) {
        g.setColor(Color.RED);
        g.drawLine(0, 0, width, height);
        g.drawLine(width, 0, 0, height);
        g.drawRect(50, 50, width - 100, height - 100);
    }

    public class PaintablePane extends JPanel {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
            paintTest(g, getWidth() - 1, getHeight() - 1);
        }
    }
}