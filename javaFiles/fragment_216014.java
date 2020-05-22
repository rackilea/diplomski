public class SimplePaint03 {

    public static void main(String[] args) {
        new SimplePaint03();
    }

    public SimplePaint03() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new PaintPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class PaintPane extends JPanel {

        private List<Shape> grid;
        private List<Shape> fill;

        public PaintPane() {
            grid = new ArrayList<>(5);
            fill = new ArrayList<>(5);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (Shape shape : grid) {
                        if (shape.contains(e.getPoint())) {
                            if (fill.contains(shape)) {
                                fill.remove(shape);
                            } else {
                                fill.add(shape);
                            }
                        }
                    }
                    repaint();
                }
            });

            int colWidth = 200 / 50;
            int rowHeight = 200 / 50;

            for (int row = 0; row < 50; row++) {
                for (int col = 0; col < 50; col++) {
                    grid.add(new Rectangle(colWidth * col, rowHeight * row, colWidth, rowHeight));
                }
            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.RED);
            for (Shape cell : fill) {
                g2d.fill(cell);
            }
            g2d.setColor(Color.BLACK);
            for (Shape cell : grid) {
                g2d.draw(cell);
            }
        }

    }

}