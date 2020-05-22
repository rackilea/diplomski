import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener {

    private JComboBox<String> months;
    private String[] monthsList = { "January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October",
            "November", "December" };
    private JPanel panel;

    private int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };// days
                                                                            // of
                                                                            // each
                                                                            // month

    public Main() {
        super("My Caleander!");

        months = new JComboBox<>(monthsList); // Adding months to Combo box.

        panel = new JPanel(); // Panel for adding labels inside.
        setLayout(new BorderLayout());

        panel.setLayout(new GridLayout(0, 7));// 0 for dynamic number of rows
                                                // and 7 for each week.

        for (int i = 0; i < 31; i++) {
            panel.add(new JLabel(String.valueOf(i + 1))); // Adding days of
                                                            // month January.
        }

        months.addActionListener(this);// Adding Action listener for responding
                                        // to change of month.

        add(months, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
        setLocationRelativeTo(null);// Putting JFrame to the center of screen.
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        new Main();

    }

    @Override
    public void actionPerformed(ActionEvent e) {// Listening to changes made by
                                                // ComboBox.

        panel.removeAll();
        int daysOfMonth = months.getSelectedIndex();// Getting the index of
                                                    // current month

        for (int i = 0; i < days[daysOfMonth]; i++) {// Adding the requiered
                                                        // number of months.
            panel.add(new JLabel(String.valueOf(i + 1)));
        }

        panel.revalidate();//Updating panel.
        revalidate();//Upadating frame.

    }

}