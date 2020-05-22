import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test{

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        protected static final int PLAY_TIME = 6000;

        private Timeline timeline;
        private long startTime;

        private Point imgPoint;
        private BufferedImage img;

        public TestPane() {

            try {
                img = ImageIO.read(new File("C:/Neko.png"));

                imgPoint = new Point(0, 200 - img.getHeight());

                timeline = new Timeline();
                timeline.add(0f, imgPoint);
                timeline.add(0.2f, new Point(0, 0));
                timeline.add(0.4f, new Point(200 - img.getWidth(), 0));
                timeline.add(0.6f, new Point(200 - img.getWidth(), 200 - img.getHeight()));
                timeline.add(0.8f, new Point(100 - (img.getWidth() / 2), 200 - img.getHeight()));
                timeline.add(1f, new Point(100 - (img.getWidth() / 2), 100 - (img.getHeight() / 2)));

                Timer timer = new Timer(40, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        long duration = System.currentTimeMillis() - startTime;
                        float progress = (float) duration / (float) PLAY_TIME;
                        if (progress > 1f) {
                            startTime = System.currentTimeMillis();
                            progress = 0;
                            ((Timer) (e.getSource())).stop();
                        }

                        System.out.println(progress);
                        imgPoint = timeline.getPointAt(progress);
                        repaint();

                    }
                });
                startTime = System.currentTimeMillis();
                timer.start();
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null && imgPoint != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.drawImage(img, imgPoint.x, imgPoint.y, this);
                g2d.dispose();
            }
        }

    }

    public static class Timeline {

        private Map<Float, KeyFrame> mapEvents;

        public Timeline() {
            mapEvents = new TreeMap<>();
        }

        public void add(float progress, Point p) {
            mapEvents.put(progress, new KeyFrame(progress, p));
        }

        public Point getPointAt(float progress) {

            if (progress < 0) {
                progress = 0;
            } else if (progress > 1) {
                progress = 1;
            }

            KeyFrame[] keyFrames = getKeyFramesBetween(progress);

            float max = keyFrames[1].progress - keyFrames[0].progress;
            float value = progress - keyFrames[0].progress;
            float weight = value / max;

            return blend(keyFrames[0].getPoint(), keyFrames[1].getPoint(), 1f - weight);

        }

        public KeyFrame[] getKeyFramesBetween(float progress) {

            KeyFrame[] frames = new KeyFrame[2];
            int startAt = 0;
            Float[] keyFrames = mapEvents.keySet().toArray(new Float[mapEvents.size()]);
            while (startAt < keyFrames.length && keyFrames[startAt] <= progress) {
                startAt++;
            }

            if (startAt >= keyFrames.length) {
                startAt = keyFrames.length - 1;
            }

            frames[0] = mapEvents.get(keyFrames[startAt - 1]);
            frames[1] = mapEvents.get(keyFrames[startAt]);

            return frames;

        }

        protected Point blend(Point start, Point end, float ratio) {
            Point blend = new Point();

            float ir = (float) 1.0 - ratio;

            blend.x = (int) (start.x * ratio + end.x * ir);
            blend.y = (int) (start.y * ratio + end.y * ir);

            return blend;
        }

        public class KeyFrame {

            private float progress;
            private Point point;

            public KeyFrame(float progress, Point point) {
                this.progress = progress;
                this.point = point;
            }

            public float getProgress() {
                return progress;
            }

            public Point getPoint() {
                return point;
            }

        }

    }
}