import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JoinedComboBoxes {

    public static void main(String[] args) {
        new JoinedComboBoxes();
    }

    public JoinedComboBoxes() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            final JComboBox<String> monthBox = new JComboBox<String>();
            monthBox.addItem("January");
            monthBox.addItem("February");
            monthBox.addItem("March");
            monthBox.addItem("April");
            monthBox.addItem("May");
            monthBox.addItem("June");
            monthBox.addItem("July");
            monthBox.addItem("August");
            monthBox.addItem("September");
            monthBox.addItem("October");
            monthBox.addItem("November");
            monthBox.addItem("December");

            setLayout(new GridBagLayout());
            add(monthBox);

            final JComboBox<Integer> days = new JComboBox<>();
            days.setEnabled(false);
            add(days);

            monthBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Calendar cal = Calendar.getInstance();
                    String month = (String) monthBox.getSelectedItem();
                    days.setEnabled(month != null);
                    if (month != null) {
                        int calMonth = 0;
                        switch (month) {
                            case "January":
                                calMonth = Calendar.JANUARY;
                                break;
                            case "February":
                                calMonth = Calendar.FEBRUARY;
                                break;
                            case "March":
                                calMonth = Calendar.MARCH;
                                break;
                            case "April":
                                calMonth = Calendar.APRIL;
                                break;
                            case "May":
                                calMonth = Calendar.MAY;
                                break;
                            case "June":
                                calMonth = Calendar.JUNE;
                                break;
                            case "July":
                                calMonth = Calendar.JULY;
                                break;
                            case "August":
                                calMonth = Calendar.AUGUST;
                                break;
                            case "September":
                                calMonth = Calendar.SEPTEMBER;
                                break;
                            case "October":
                                calMonth = Calendar.OCTOBER;
                                break;
                            case "November":
                                calMonth = Calendar.NOVEMBER;
                                break;
                            case "December":
                                calMonth = Calendar.DECEMBER;
                                break;
                        }
                        days.removeAllItems();
                        cal.setTime(new Date()); // For the current year...
                        cal.set(Calendar.MONTH, calMonth);
                        int min = cal.getActualMinimum(Calendar.DATE);
                        int max = cal.getActualMaximum(Calendar.DATE);
                        for (int day = min; day <= max; day++) {
                            days.addItem(day);
                        }
                    }
                }
            });
            monthBox.setSelectedItem(null);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.dispose();
        }
    }
}