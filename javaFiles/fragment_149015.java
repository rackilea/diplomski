import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Test {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }

    public Test() {
        createAndShowGui();
    }

    public void createAndShowGui() {

        final JFrame employeeFrame = new JFrame("Report");
        employeeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final JPanel panel = new JPanel() {
            @Override
            public Dimension getMinimumSize() {
                return new Dimension(250, 0);
            }
        };
        final JTable table2 = new JTable(new String[][]{
                    {"one", "two", "three"},
                    {"one", "two", "three"},
                    {"one", "two", "three"}
                }, new String[]{"col1", "col2", "col3"});

        JPanel panel1 = new JPanel(new BorderLayout());//panel which holds jtable
        final JLabel label1;
        final JLabel label2;
        final JTextField text1;
        final JTextField text2;
        final JButton ADD;

        label1 = new JLabel("From Date");
        text1 = new JTextField(12);
        label2 = new JLabel("End Date");
        text2 = new JTextField(12);
        JButton button2 = new JButton("calendar");
        ADD = new JButton("Search");
        ADD.setText("Search");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                /*
                 DbUtility createAndShowGui = new DbUtility();
                 createAndShowGui.loadDriver();
                 createAndShowGui.connect();

                 String value = (text1.getText());
                 String value2 = (text2.getText());
                 ResultSet rs = createAndShowGui.executeSelectQuery14(value, value2);
                 String Activityid = null, EmployeeName = null, StartDate = null, EndDate = null, Activity = null, Project = null, Day1 = null, Day2 = null, Day3 = null, Day4 = null, Day5 = null;

                 try {
                 while (rs.next()) {
                 Activityid = rs.getString("Activityid");
                 EmployeeName = rs.getString("EmployeeName");
                 StartDate = rs.getString("StartDate");
                 EndDate = rs.getString("EndDate");
                 Activity = rs.getString("Activity");
                 Project = rs.getString("Project");
                 Day1 = rs.getString("Day1");
                 Day2 = rs.getString("Day2");
                 Day3 = rs.getString("Day3");
                 Day4 = rs.getString("Day4");
                 Day5 = rs.getString("Day5");

                 String[] columnNames = {"Activityid", "EmployeeName", "StatrDate", "EndDate", "Activity", "Project", "Day1", "Day2", "Day3", "Day3", "Day4", "Day5"};
                 String data[][] = {{Activityid, EmployeeName, StartDate, EndDate, Activity, Project, Day1, Day2, Day3, Day4, Day5}};
                 System.out.println(Activityid + " " + EmployeeName + " " + StartDate + "" + EndDate + "" + Activity + " " + Project + "" + Day1 + "" + Day2 + "" + Day3 + "" + Day4 + "" + Day5);
                 final DefaultTableModel model = new DefaultTableModel(data, columnNames);
                 table2 = new JTable(model);
                 table2.setRowHeight(70);
                 table2.setFillsViewportHeight(true);
                 JTextField field = new JTextField();
                 field.setForeground(Color.RED);
                 field.setBackground(Color.RED);
                 table2.getTableHeader().setPreferredSize(new Dimension(50, 50));
                 table2.getTableHeader().setBackground(Color.blue);
                 table2.getTableHeader().setForeground(Color.white);
                 table2.getTableHeader().setFont(new Font("Serif", Font.BOLD, 15));
                 table2.getTableHeader().setOpaque(true);
                 table2.getModel();
                 table2.setForeground(Color.blue);
                 table2.setBackground(Color.white);
                 table2.setGridColor(Color.MAGENTA);
                 table2.setShowGrid(true);

                 }
                 } catch (SQLException e1) {
                 e1.printStackTrace();
                 }
                 */
            }
        });

        panel.add(label1);
        label1.setForeground(Color.white);
        panel.add(text1);
        panel.add(label2);
        label2.setForeground(Color.white);
        panel.add(text2);
        panel.add(ADD);

        JScrollPane pane = new JScrollPane(table2);
        panel1.add(pane);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel, panel1);
        splitPane.setDividerLocation(300);

        employeeFrame.add(splitPane);

        employeeFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        //employeeFrame.setLocation(100, 50);
        employeeFrame.pack();

        employeeFrame.setVisible(true);
        employeeFrame.setResizable(false);//or else it wont work nicely withn JFrame#setExtendedState
    }
}