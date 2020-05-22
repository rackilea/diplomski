import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private String text = "All your base belong to us";
        private int index;

        private JLabel label = new JLabel("");

        public TestPane() {
            setLayout(new GridBagLayout());
            add(label);

            Timer timer = new Timer(35, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    label.setText(text.substring(0, index));
                    index++;
                    if (index > text.length()) {
                        ((Timer) evt.getSource()).stop();
                    }
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 200);
        }

    }

}