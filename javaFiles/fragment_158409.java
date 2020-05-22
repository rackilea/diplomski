import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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

        private JLabel label;
        private JTextField field;
        private Timer timer;
        private char[] values;
        private int index;

        private Random rnd;

        public TestPane() {
            rnd = new Random();

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            label = new JLabel("...");
            field = new JTextField(10);
            JButton btn = new JButton("Start");

            add(label, gbc);
            add(field, gbc);
            add(btn, gbc);

            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    StringBuilder sb = new StringBuilder(field.getText());
                    sb.append(values[index]);
                    field.setText(sb.toString());

                    index++;
                    if (index >= values.length) {
                        ((Timer)e.getSource()).stop();
                    }
                }
            });
            timer.setInitialDelay(0);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (timer.isRunning()) {
                        timer.stop();
                    }
                    field.setText("");
                    index = 0;
                    int number = rnd.nextInt(999);
                    String text = Integer.toString(number);
                    label.setText(text);
                    values = text.toCharArray();
                    timer.start();
                }
            });
        }

    }

}