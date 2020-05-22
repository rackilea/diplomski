import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MoveLabel {

    public static void main(String[] args) {
        new MoveLabel();
    }

    public MoveLabel() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(new BorderLayout());
                TestPane testPane = new TestPane();
                testPane.setBackground(Color.WHITE);
                frame.getContentPane().add(testPane);

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class TestPane extends JPanel {

        private JTextField tf;
        private List<JTextField> tracks;

        protected static final int PLAY_TIME = 4000;

        private Timeline timeline;
        private long startTime;

        public TestPane() {
            setLayout(null);

            tracks = new ArrayList<JTextField>(20);

            int x = 20;
            int y = 20;

            for (int index = 0; index < 6; index++) {
                x += 20;
                tracks.add(createTrack(x, y, 20, 20));
            }
            for (int index = 0; index < 6; index++) {
                y += 20;
                tracks.add(createTrack(x, y, 20, 20));
            }
            for (int index = 0; index < 6; index++) {
                x -= 20;
                tracks.add(createTrack(x, y, 20, 20));
            }
            for (int index = 0; index < 6; index++) {
                y -= 20;
                tracks.add(createTrack(x, y, 20, 20));
            }

            for (JTextField track : tracks) {
                add(track);
            }

            tf = new JTextField("");
            tf.setSize(20, 20);
            tf.setBackground(Color.red);
            add(tf);
            setComponentZOrder(tf, 0);

            timeline = new Timeline();
            timeline.add(0, new Point(20, 20));
            timeline.add(0.25f, new Point(20 * 7, 20));
            timeline.add(0.5f, new Point(20 * 7, 20 * 7));
            timeline.add(0.75f, new Point(20, 20 * 7));
            timeline.add(1f, new Point(20, 20));

            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    long duration = System.currentTimeMillis() - startTime;
                    float progress = (float) duration / (float) PLAY_TIME;
                    if (progress > 1f) {
                        startTime = System.currentTimeMillis();
                        progress = 0;
//                      ((Timer) (e.getSource())).stop();
                    }

                    Point p = timeline.getPointAt(progress);
                    tf.setLocation(p);

                }
            });
            startTime = System.currentTimeMillis();
            timer.start();

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 500);

        }

        protected JTextField createTrack(int x, int y, int width, int height) {
            JTextField field = new JTextField();
            field.setBounds(x, y, width, height);
            field.setEditable(false);
            field.setFocusable(false);
            return field;
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

        protected  Point blend(Point start, Point end, float ratio) {
            Point blend = new Point();

            float ir = (float) 1.0 - ratio;

            blend.x = (int)(start.x * ratio + end.x * ir);
            blend.y = (int)(start.y * ratio + end.y * ir);

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