public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                Canvas canvas = new Canvas();
                canvas.setPreferredSize(new Dimension(200, 200));

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setIgnoreRepaint(true);
                frame.add(canvas);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                canvas.createBufferStrategy(2);

                Thread t = new Thread(new Painter(canvas));
                t.setDaemon(true);
                t.start();

            }
        });
    }

    public class Painter implements Runnable {

        private Canvas canvas;

        public Painter(Canvas canvas) {
            this.canvas = canvas;
        }

        @Override
        public void run() {
            while (true) {
                BufferStrategy bs = canvas.getBufferStrategy();
                Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
                g2d.setColor(Color.RED);
                g2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

                int width = canvas.getWidth();
                int height = canvas.getHeight();

                FontMetrics fm = g2d.getFontMetrics();
                g2d.setColor(Color.BLACK);
                g2d.drawString("Size = " + width + "x" + height, 0, fm.getAscent());

                Window w = SwingUtilities.windowForComponent(canvas);
                g2d.drawString("Frame Size = " + w.getWidth() + "x" + w.getHeight(), 0, (fm.getHeight()) + fm.getAscent());

                g2d.dispose();
                bs.show();

                try {
                    Thread.sleep(30);
                } catch (InterruptedException ex) {
                }
            }
        }
    }
}