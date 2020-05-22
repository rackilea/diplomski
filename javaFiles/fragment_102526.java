import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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

        public TestPane() {
            setLayout(null);
            Slider slider1 = new Slider();
            slider1.setBackground(Color.BLUE);
            slider1.setLocation(0, 44);         
            add(slider1);

            Slider slider2 = new Slider();
            slider2.setBackground(Color.MAGENTA);
            slider2.setLocation(0, 88);
            add(slider2);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class Slider extends JPanel {

        private AnimationProperties<Integer> ap;

        private IntRange maxRange = new IntRange(44, 150);
        private Duration duration = Duration.ofSeconds(5);

        public Slider() {
            setSize(44, 44);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    animateTo(150);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    animateTo(44);
                }

                public void animateTo(int to) {
                    if (ap != null) {
                        Animator.INSTANCE.remove(ap);
                    }
                    IntRange animationRange = new IntRange(getWidth(), to);
                    ap = new IntAnimationProperties(animationRange, maxRange, duration, new AnimationPropertiesListener<Integer>() {
                        @Override
                        public void stateChanged(AnimationProperties<Integer> animator) {
                            setSize(animator.getValue(), 44);
                            repaint();
                        }
                    });
                    Animator.INSTANCE.add(ap);
                }

            });
        }

    }

    public enum Animator {

        INSTANCE;

        private Timer timer;

        private List<AnimationProperties> properies;

        private Animator() {
            properies = new ArrayList<>(5);
            timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Iterator<AnimationProperties> it = properies.iterator();
                    while (it.hasNext()) {
                        AnimationProperties ap = it.next();
                        if (ap.tick()) {
                            it.remove();
                        }
                    }
                    if (properies.isEmpty()) {
                        timer.stop();
                    }
                }
            });
        }

        public void add(AnimationProperties ap) {
            properies.add(ap);
            timer.start();
        }

        public void remove(AnimationProperties ap) {
            properies.remove(ap);
            if (properies.isEmpty()) {
                timer.stop();
            }
        }

    }

    public interface AnimationProperties<T> {
        public Range<T> getRange();
        public T getValue();
        public boolean tick();

        public void setDuration(Duration duration);
        public Duration getDuration();
    }

    public interface AnimationPropertiesListener<T> {
        public void stateChanged(AnimationProperties<T> animator);
    }

    public class Range<T> {
        private T from;
        private T to;

        public Range(T from, T to) {
            this.from = from;
            this.to = to;
        }

        public T getFrom() {
            return from;
        }

        public T getTo() {
            return to;
        }

        @Override
        public String toString() {
            return "From " + getFrom() + " to " + getTo();
        }

    }

    public abstract class AbstractAnimationProperties<T> implements AnimationProperties<T> {

        private Range<T> range;

        private LocalDateTime startTime;

        private Duration duration = Duration.ofSeconds(5);

        private T value;

        private AnimationPropertiesListener<T> listener;

        public AbstractAnimationProperties(Range<T> range, AnimationPropertiesListener<T> listener) {
            this.range = range;
            this.value = range.getFrom();

            this.listener = listener;
        }

        public void setDuration(Duration duration) {
            this.duration = duration;
        }

        public Duration getDuration() {
            return duration;
        }

        public Range<T> getRange() {
            return range;
        }

        @Override
        public T getValue() {
            return value;
        }

        @Override
        public boolean tick() {
            if (startTime == null) {
                startTime = LocalDateTime.now();
            }
            Duration duration = getDuration();
            Duration runningTime = Duration.between(startTime, LocalDateTime.now());
            Duration timeRemaining = duration.minus(runningTime);
            if (timeRemaining.isNegative()) {
                runningTime = duration;
            }
            double progress = (runningTime.toMillis() / (double) duration.toMillis());
            value = calculateValue(progress);

            listener.stateChanged(this);

            return progress >= 1.0;
        }

        public abstract T calculateValue(double progress);

    }

    public class IntRange extends Range<Integer> {

        public IntRange(Integer from, Integer to) {
            super(from, to);
        }

        public Integer getDistance() {
            return getTo() - getFrom();
        }
    }

    public class IntAnimationProperties extends AbstractAnimationProperties<Integer> {

        public IntAnimationProperties(IntRange animationRange, IntRange maxRange, Duration duration, AnimationPropertiesListener<Integer> listener) {
            super(animationRange, listener);

            int maxDistance = maxRange.getDistance();
            int aniDistance = animationRange.getDistance();

            double progress = Math.min(100, Math.max(0, Math.abs(aniDistance/ (double)maxDistance)));
            Duration remainingDuration = Duration.ofMillis((long)(duration.toMillis() * progress));
            setDuration(remainingDuration);
        }

        @Override
        public Integer calculateValue(double progress) {
            IntRange range = (IntRange)getRange();
            int distance = range.getDistance();
            int value = (int) Math.round((double) distance * progress);
            value += range.getFrom();
            return value;
        }

    }

}