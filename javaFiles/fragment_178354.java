import java.awt.*;
import javax.swing.*;

class SackEmployee {
    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                Employee[] workforce = {
                    new Employee("Ali Ben Messaoud", 9823),
                    new Employee("Jane Brewer", 6348),
                    new Employee("John Smith", 1247),
                    new Employee("John Smith", 4385)
                };

                JComboBox employeeCombo = new JComboBox(workforce);

                EmployeeCellRenderer employeeCellRenderer = new EmployeeCellRenderer();
                employeeCombo.setRenderer(employeeCellRenderer);

                int result = JOptionPane.showConfirmDialog(
                    null,
                    employeeCombo,
                    "Fire Employee?",
                    JOptionPane.OK_CANCEL_OPTION);
                // cast selected item back to Employee.
                Employee employee = (Employee)employeeCombo.getSelectedItem();
                System.out.println( "Fire '" + employee + "' now?" );
                System.out.println( "Proceed: " + (result==JOptionPane.OK_OPTION) );
            }
        });
    }
}

class Employee {

    int id;
    String name;

    Employee(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public String getIdString() {
        return "ID-" + id;
    }

    public String toString() {
        return getIdString() + ": " + name;
    }
}

class EmployeeCellRenderer implements ListCellRenderer {

    JLabel label = new JLabel();

    public Component getListCellRendererComponent(
        JList list,
        Object value,
        int index,
        boolean isSelected,
        boolean cellHasFocus) {

        Employee employee = (Employee)value;
        // distinguish between people of same name by adding ID.
        label.setText(employee.name + " (" + employee.getIdString() + ")");

        return label;
    }
}