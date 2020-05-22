import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalTime;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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

        private JTextArea ta;       
        private JButton btn;

        private Timer timer;

        private LocalTime startTime, endTime;

        public TestPane() {
            setLayout(new BorderLayout());
            ta = new JTextArea(10, 20);
            add(new JScrollPane(ta));
            btn = new JButton("Click");
            add(btn, BorderLayout.SOUTH);

            timer = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    endTime = LocalTime.now();
                    Duration duration = Duration.between(startTime, endTime);
                    ta.append("Ended @ " + endTime + "\n");
                    ta.append("Took " + (duration.toMillis() / 1000) + " seconds\n");
                }
            });
            timer.setRepeats(false);

            ta.setEditable(false);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timer.start();
                    startTime = LocalTime.now();
                    btn.setEnabled(false);
                    ta.append("Start @ " + startTime + "\n");
                }
            });
        }

    }

}