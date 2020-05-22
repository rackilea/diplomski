import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.EventListenerList;

public class TimerTest {

    public static void main(String[] args) {
        new TimerTest();
    }

    public TimerTest() {
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

        private JLabel label = new JLabel("00:00:00.00");

        public TestPane() {
            setLayout(new GridBagLayout());
            add(label);
            DefaultTimedTask task = new DefaultTimedTask(Duration.ofMinutes(3), 100);
            task.addTimedTaskTickListener(new TimedTaskTickListener() {
                @Override
                public void timedTaskTicked(TimedTaskEvent evt) {
                    TimedTask task = (TimedTask) evt.getSource();
                    Duration duration = task.getTotalDuration();
                    label.setText(format(duration));
                }
            });

            TaskList taskList = new TaskList();
            taskList.add(task);
            taskList.start();
        }

        public String format(Duration duration) {
            long hours = duration.toHours();
            duration = duration.minusHours(hours);
            long minutes = duration.toMinutes();
            duration = duration.minusMinutes(minutes);
            long millis = duration.toMillis();
            double seconds = millis / 1000.0;

            return String.format("%02d:%02d:%02.02f", hours, minutes, seconds);
        }
    }
}