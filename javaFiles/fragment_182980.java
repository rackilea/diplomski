import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;

public class Test1 {

    public static void main(String[] args) {
        new Test1();
    }

    public Test1() {
        SwingUtilities.invokeLater(new Runnable() {
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

        private JSpinner time_spinner;

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            Date date = new Date();
            SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);

            time_spinner = new javax.swing.JSpinner(sm);

            JSpinner.DateEditor te = new JSpinner.DateEditor(time_spinner, "HH:mm:ss");
            time_spinner.setEditor(te);

            add(time_spinner, gbc);

            JButton btn = new JButton("Show me the time");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Object value = time_spinner.getValue();
                    if (value instanceof Date) {
                        Date date = (Date)value;
                        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                        String time = format.format(date);

                        JOptionPane.showMessageDialog(TestPane.this, "The time is " + time);
                    }
                }
            });
            add(btn, gbc);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

}