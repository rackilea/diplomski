import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MonthlyData {

    public double emailvalue;
    private String[] date = {"Day", "Week", "Month"};
    private JFrame frame;

    public MonthlyData() {
        frame = new JFrame();//use an instance rather than extending the class
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JComboBox date1 = new JComboBox(date);

        ActionListener cbActionListener = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) date1.getSelectedItem();//get the selected item

                switch (s) {//check for a match
                    case "Day":
                        emailvalue = 1.1;
                        System.out.println("Day selected, emailvalue:" + emailvalue);
                        break;
                    case "Week":
                        emailvalue = 2.2;
                        System.out.println("Week selected, emailvalue:" + emailvalue);
                        break;
                    case "Month":
                        emailvalue = 3.3;
                        System.out.println("Month selected, emailvalue:" + emailvalue);
                        break;
                    default:
                        emailvalue = 4.4;
                        System.out.println("No match selected, emailvalue:" + emailvalue);
                        break;
                }
            }
        };

        date1.addActionListener(cbActionListener);

        frame.add(date1);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MonthlyData();
            }
        });
    }
}