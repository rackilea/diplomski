public class TestGraphics01 {

    public static void main(String[] args) {
        new TestGraphics01();
    }

    public TestGraphics01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestGraphicsPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestGraphicsPane extends JPanel {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            FontMetrics fm = g.getFontMetrics();

            // This creates a "copy" the graphics context, it's translated
            // to the x, y position within the current graphics context
            // and has a width and height.  If the width or height is outside
            // the current graphics context, then it is truncated...
            // It's kind of like clip, except what ever you do to this copy
            // does not effect the graphics context it came from...
            // This would be simular to setting the clipping region, just it 
            // won't effect the parent Graphics context it was copied from...
            Graphics create = g.create(100, 100, 200, 200);
            create.setColor(Color.GREEN);
            create.fillRect(0, 0, 200, 200);
            create.setColor(Color.YELLOW);
            create.drawString("I'm inside...", 0, fm.getAscent());
            create.dispose();

            // But I remain uneffected...
            g.drawString("I'm outside...", 0, fm.getAscent());

            // I will effect every thing draw afterwards...
            g.setColor(Color.RED);
            int y = 50 - (fm.getHeight() / 2) + fm.getAscent();
            g.translate(50, y);
            g.drawString("I'm half way", 0, 0);
            // You must reset the translation if you want to reuse the graphics OR
            // you didn't create a copy...
            g.translate(-50, -y);

            y = 350 - (fm.getHeight() / 2) + fm.getAscent();
            g.translate(300, y);
            g.drawString("I'm half way", 0, 0);
            // You must reset the translation if you want to reuse the graphics OR
            // you didn't create a copy...
            g.translate(-300, -y);

        }

    }

}