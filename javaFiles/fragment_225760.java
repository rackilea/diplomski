import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        private String[] messages = {
            "Example 1",
            "Example 2",
            "Example 3",
            "Example 4",
            "Example 5",
            "Example 6",
            "Example 7",
            "Example 8",
            "Example 9",
        };

        private JTextArea ta;
        private int index;

        private Timer timer;

        public TestPane() {
            setLayout(new BorderLayout());
            ta = new JTextArea(1, 20);
            add(new JScrollPane(ta));

            JButton btn = new JButton("Start");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (timer.isRunning()) {
                        timer.stop();
                    }
                    index = 0;
                    timer.start();
                }
            });
            add(btn, BorderLayout.SOUTH);

            timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (index < messages.length) {
                        ta.setText(messages[index]);
                    } else {
                        timer.stop();
                    }
                    index++;
                }
            });
        }

    }

}