import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultRowSorter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

/** @see https://stackoverflow.com/a/37892395/230513 */
public class JTableRunningTotalExample extends JFrame {

    private final NumberCellFormatter numberCellFormatter = new NumberCellFormatter();

    public JTableRunningTotalExample() {
        super("JTable Sorting Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTable table = new JTable() {
            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return new Dimension(500, getRowCount() * getRowHeight());
            }
        };
        List<Employee> listEmployees = createListEmployees();
        TableModel model = new EmployeeTableModel(table, listEmployees);
        table.setModel(model);
        table.setAutoCreateRowSorter(true);
        DefaultRowSorter sorter = (DefaultRowSorter) table.getRowSorter();
        sorter.setSortable(4, false);
        for (int j = 3; j < 5; j++) {
            table.getColumnModel().getColumn(j).setCellRenderer(numberCellFormatter);
        }
        add(new JScrollPane(table), BorderLayout.CENTER);
        pack();
    }

    private List<Employee> createListEmployees() {
        List<Employee> listEmployees = new ArrayList<>();
        listEmployees.add(new Employee("Peter", "Manager", 40000));
        listEmployees.add(new Employee("Paul", "Programmer", 25000));
        listEmployees.add(new Employee("Mary", "Designer", 25000));
        listEmployees.add(new Employee("Donald", "Leader", 30000));
        listEmployees.add(new Employee("Tom", "Designer", 28000));
        listEmployees.add(new Employee("Samantha", "Analyst", 50000));
        listEmployees.add(new Employee("Jerome", "Programmer", 32000));
        listEmployees.add(new Employee("Jonathon", "Developer", 29000));
        listEmployees.add(new Employee("Kevin", "Programmer", 23000));
        listEmployees.add(new Employee("Anthony", "Programmer", 23000));
        listEmployees.add(new Employee("John", "Designer", 33000));
        listEmployees.add(new Employee("David", "Developer", 28000));
        listEmployees.add(new Employee("Harry", "Designer", 31000));
        listEmployees.add(new Employee("Charles", "Programmer", 26000));
        listEmployees.add(new Employee("Joseph", "Manager", 40000));
        return listEmployees;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTableRunningTotalExample frame = new JTableRunningTotalExample();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private static class EmployeeTableModel extends AbstractTableModel {

        private static final int COLUMN_NUM = 0;
        private static final int COLUMN_NAME = 1;
        private static final int COLUMN_JOB = 2;
        private static final int COLUMN_SALARY = 3;
        private static final int COLUMN_SUM = 4;

        private String[] columnNames = {"No", "Name", "Job", "Salary", "Total Payroll"};
        JTable table;
        private List<Employee> listEmployees;

        public EmployeeTableModel(JTable table, List<Employee> listEmployees) {
            this.table = table;
            this.listEmployees = listEmployees;
            int indexCount = 1;
            for (Employee employee : listEmployees) {
                employee.setIndex(indexCount++);
            }
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return listEmployees.size();
        }

        @Override
        public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return getValueAt(0, columnIndex).getClass();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Employee employee = listEmployees.get(rowIndex);
            switch (columnIndex) {
                case COLUMN_NUM:
                    return employee.getIndex();
                case COLUMN_NAME:
                    return employee.getName();
                case COLUMN_JOB:
                    return employee.getJob();
                case COLUMN_SALARY:
                    return employee.getSalary();
                case COLUMN_SUM:
                    return partialSum(rowIndex);
                default:
                    throw new IllegalArgumentException("Invalid column index");
            }
        }

        private int partialSum(int row) {
            int viewRow = table.convertRowIndexToView(row);
            int viewCol = table.convertColumnIndexToView(COLUMN_SALARY);
            int sum = (int) table.getValueAt(viewRow, viewCol);
            for (int i = 0; i < viewRow; i++) {
                sum += (int) table.getValueAt(i, viewCol);
            }
            return sum;
        }
    }

    private static class Employee {

        private int index;
        private String name;
        private String job;
        private int salary;

        public Employee(String name, String job, int salary) {
            this.name = name;
            this.job = job;
            this.salary = salary;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int age) {
            this.salary = age;
        }
    }

    private static class NumberCellFormatter extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;
        private NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        private double formattedNumber;

        public double setNumberFormat(String number) {
            formattedNumber = Double.parseDouble(numberFormat.format(number));
            return formattedNumber;
        }

        @Override
        public Component getTableCellRendererComponent(JTable jTable, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(jTable, value,
                isSelected, hasFocus, row, column);
            if (c instanceof JLabel && value instanceof Number) {
                JLabel label = (JLabel) c;
                label.setHorizontalAlignment(JLabel.RIGHT);
                Number num = (Number) value;
                String text = numberFormat.format(num);
                label.setText(text);
                label.setForeground(num.doubleValue() < 0 ? Color.RED : Color.BLACK);
            }
            return c;
        }
    }
}