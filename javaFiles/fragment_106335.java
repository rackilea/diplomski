import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TestCanvas canvas = new TestCanvas();

                JFrame frame = new JFrame();
                frame.add(canvas);
                frame.setTitle("Test");
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                canvas.start();
            }
        });
    }

    public class TestCanvas extends Canvas {

        private Thread thread;
        private AtomicBoolean keepRendering = new AtomicBoolean(true);

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public void stop() {
            if (thread != null) {
                keepRendering.set(false);
                try {
                    thread.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        public void start() {
            if (thread != null) {
                stop();
            }

            keepRendering.set(true);
            thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    createBufferStrategy(3);

                    do {
                        BufferStrategy bs = getBufferStrategy();
                        while (bs == null) {
                            System.out.println("get buffer");
                            bs = getBufferStrategy();
                        }
                        do {
                            // The following loop ensures that the contents of the drawing buffer
                            // are consistent in case the underlying surface was recreated
                            do {
                                // Get a new graphics context every time through the loop
                                // to make sure the strategy is validated
                                System.out.println("draw");
                                Graphics graphics = bs.getDrawGraphics();

                                // Render to graphics
                                // ...
                                graphics.setColor(Color.RED);
                                graphics.fillRect(0, 0, 100, 100);
                                // Dispose the graphics
                                graphics.dispose();

                                // Repeat the rendering if the drawing buffer contents
                                // were restored
                            } while (bs.contentsRestored());

                            System.out.println("show");
                            // Display the buffer
                            bs.show();

                            // Repeat the rendering if the drawing buffer was lost
                        } while (bs.contentsLost());
                        System.out.println("done");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    } while (keepRendering.get());
                }
            });
            thread.start();
        }

    }

}