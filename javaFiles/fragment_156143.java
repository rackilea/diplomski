import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class EmployeeFrame extends JFrame implements ActionListener {
    private JButton addButton;

    private DefaultListModel<Employee> listModel;
    private JList<Employee> employeeList;

    public EmployeeFrame() {
        super("Employee Manager");
        setLocationByPlatform(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        employeeList = new JList<>(listModel);
        JScrollPane employeeScroll = new JScrollPane(employeeList);
        employeeScroll.setBorder(new TitledBorder("Employee List"));

        addButton = new JButton("Add Employee");
        addButton.addActionListener(this);

        Box topBox = Box.createHorizontalBox();
        topBox.add(addButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topBox, BorderLayout.NORTH);
        getContentPane().add(employeeScroll, BorderLayout.CENTER);
        pack();
    }

    public DefaultListModel<Employee> getListModel() {
        return this.listModel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == addButton) {
            // !! AddEmployeeDialog frame = new AddEmployeeDialog(new EmployeeFrame());
            AddEmployeeDialog frame = new AddEmployeeDialog(EmployeeFrame.this);
            frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EmployeeFrame().setVisible(true);
            }
        });
    }

}

@SuppressWarnings("serial")
class AddEmployeeDialog extends JDialog implements ActionListener {
    private JComboBox<String> workerType;
    private JTextField givenNameField;
    private JTextField familyNameField;

    private JButton okButton;
    private JButton cancelButton;

    private EmployeeFrame employeeFrame;

    public AddEmployeeDialog(final EmployeeFrame frame) {
        super(frame, "Add Employee", true);
        setLocationRelativeTo(employeeFrame);
        this.employeeFrame = frame;

        workerType = new JComboBox<String>(Employee.getEmployeeTypes());
        givenNameField = new JTextField(20);
        familyNameField = new JTextField(20);

        Box workerBox = Box.createHorizontalBox();
        workerBox.add(new JLabel("Worker type"));
        workerBox.add(workerType);
        workerBox.add(new JLabel("Start date"));
        Box givenNameBox = Box.createHorizontalBox();
        givenNameBox.add(new JLabel("Given name "));
        givenNameBox.add(givenNameField);

        Box familyNameBox = Box.createHorizontalBox();
        familyNameBox.add(new JLabel("Family name"));
        familyNameBox.add(familyNameField);

        workerType.setSelectedItem(null);

        // Create buttons and add the current class as an ActionListener
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);

        Box bottomBox = Box.createHorizontalBox();
        bottomBox.add(Box.createHorizontalGlue());
        bottomBox.add(okButton);
        bottomBox.add(Box.createHorizontalGlue());
        bottomBox.add(cancelButton);
        bottomBox.add(Box.createHorizontalGlue());

        // Lay out the GUI
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(workerBox);
        getContentPane().add(givenNameBox);
        getContentPane().add(familyNameBox);
        getContentPane().add(Box.createVerticalStrut(10));
        getContentPane().add(bottomBox);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == okButton) {
            System.out.println("here");
            System.out.println(workerType.getSelectedItem());
            if ("Salaried".equalsIgnoreCase(workerType.getSelectedItem().toString())) {
                Employee employee = new Employee("Salaried", givenNameField.getText(), familyNameField.getText());
                employeeFrame.getListModel().addElement(employee);
            } else {
                Employee employee = new Employee("Hourly", givenNameField.getText(), familyNameField.getText());
                employeeFrame.getListModel().addElement(employee);
            }
        }
        dispose();
    }

}

class Employee {

    private static final String[] EMPLOYEE_TYPES = { "Salaried", "Hourly" };
    private String givenName;
    private String familyName;
    private String type;

    public Employee(String type, String givenName, String familyName) {
        this.type = type;
        this.givenName = givenName;
        this.familyName = familyName;
    }

    public static String[] getEmployeeTypes() {
        return EMPLOYEE_TYPES;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s, %s %s", type, givenName, familyName);
    }

}