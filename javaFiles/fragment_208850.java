import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class PayrollFrame extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                PayrollFrame frame = new PayrollFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private JLabel nameMessageLabel, hourMessageLabel, rateMessageLabel, boxMessageLabel;
    private JTextField nameTextField, hourTextField, rateTextField;
    private JPanel inputPanel, buttonPanel, outputPanel, inputPanel1, inputPanel2, inputPanel3, inputPanel4;
    private JComboBox<String> departmentBox;
    private JButton addButton, displayButton, exitButton;
    private JTable resultTable;
    private String[] columnNames = {"Employee name", "Department", "Weekly Salary"};
    private Object[][] data;
    private int WINDOW_WIDTH = 400;
    private int WINDOW_HEIGHT = 500;

    ArrayList<String> name = new ArrayList<String>();
    ArrayList<String> hour = new ArrayList<String>();
    ArrayList<String> rate = new ArrayList<String>();
    ArrayList<String> department = new ArrayList<String>();
    ArrayList<String> salary = new ArrayList<String>();

    private String[] departments = {"IT", "Marketing", "Human Resource", "Sales", "Customer Service", "Financial"};

    /*default constructor*/
    public PayrollFrame() {
        super("Payroll");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        buildInputPanel();
        buildButtonPanel();
        buildOutputPanel();

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel);
        add(outputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void buildInputPanel() {
        nameMessageLabel = new JLabel("Employee Name: ");
        hourMessageLabel = new JLabel("Work Hour: ");
        rateMessageLabel = new JLabel("Hourly Rate: ");
        boxMessageLabel = new JLabel("Department: ");
        nameTextField = new JTextField(10);
        hourTextField = new JTextField(10);
        rateTextField = new JTextField(10);
        departmentBox = new JComboBox<String>(departments);

        inputPanel = new JPanel();
        inputPanel1 = new JPanel();
        inputPanel2 = new JPanel();
        inputPanel3 = new JPanel();
        inputPanel4 = new JPanel();

        inputPanel1.add(nameMessageLabel);
        inputPanel1.add(nameTextField);
        inputPanel2.add(hourMessageLabel);
        inputPanel2.add(hourTextField);
        inputPanel3.add(rateMessageLabel);
        inputPanel3.add(rateTextField);
        inputPanel4.add(boxMessageLabel);
        inputPanel4.add(departmentBox);

        inputPanel.add(inputPanel1);
        inputPanel.add(inputPanel2);
        inputPanel.add(inputPanel3);
        inputPanel.add(inputPanel4);
    }

    private void buildButtonPanel() {
        addButton = new JButton("Add More");
        addButton.addActionListener(new ButtonAction());
        displayButton = new JButton("Display Result");
        displayButton.addActionListener(new ButtonAction());
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ButtonAction());

        buttonPanel = new JPanel();

        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(exitButton);
    }

    private void buildOutputPanel() {
        outputPanel = new JPanel(new BorderLayout());
        resultTable = new JTable();
        outputPanel.add(new JScrollPane(resultTable));      
    }

    /*Copy ArrayList into 2D array to display in JTable format*/
    private void printData() {
        for (int i = 0; i < name.size(); i++) {
            data[i][0] = name.get(i);
            data[i][2] = department.get(i);
            data[i][2] = salary.get(i);
        }
        TableModel model = new DefaultTableModel(data, columnNames);
        resultTable.setModel(model);
    }

    /*Function of 3 buttons*/
    private class ButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ("Add More".equals(e.getActionCommand())) {
                name.add(nameTextField.getText());
                hour.add(hourTextField.getText());
                rate.add(rateTextField.getText());
                department.add((String) departmentBox.getSelectedItem());
                calculateSalary(hourTextField.getText(), rateTextField.getText());
                nameTextField.setText("");
                hourTextField.setText("");
                rateTextField.setText("");
            } else if ("Display Result".equals(e.getActionCommand())) {

                printData();

            } else if ("Exit".equals(e.getActionCommand())) {
                System.exit(0);
            }
        }

        /*Calculate the weekly salary*/
        private void calculateSalary(String hourString, String rateString) {
            int tempHour = Integer.parseInt(hourString);
            double tempRate = Double.parseDouble(rateString);
            if (tempHour <= 40) {
                salary.add(Double.toString(tempHour * tempRate));
            } else {
                salary.add(Double.toString(40 * tempRate + (tempHour - 40) * (tempRate * 1.5))); //all hour after 40 will pay 1.5
            }
        }
    }
}