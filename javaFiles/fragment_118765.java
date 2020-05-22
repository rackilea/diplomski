import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
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

        private EmployeeTableModel model = new EmployeeTableModel();

        public TestPane() {
            setLayout(new BorderLayout());
            add(new JScrollPane(new JTable(model)));

            JButton add = new JButton("Add");
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = model.getRowCount();
                    EmployeeDetails ed = new EmployeeDetails("Employee " + row, "@ " + row, "Metro" + row, Integer.toString(row));
                    model.add(ed);
                }
            });
            add(add, BorderLayout.SOUTH);
        }

    }

    public static class EmployeeTableModel extends AbstractTableModel {

        protected static String [] COLUMN_NAMES = {"NAME", "ADDRESS", "CITY", "ZICODE"};

        private List<EmployeeDetails> rows = new ArrayList<>(25);

        @Override
        public int getRowCount() {
            return rows.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMN_NAMES.length;
        }

        @Override
        public String getColumnName(int column) {
            return COLUMN_NAMES[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            EmployeeDetails ed = rows.get(rowIndex);
            switch (columnIndex) {
                case 0: return ed.getName();
                case 1: return ed.getAddress();
                case 2: return ed.getCity();
                case 3: return ed.getZip();
            }
            return null;
        }

        public void add(EmployeeDetails ed) {
            rows.add(ed);
            int row = rows.size() - 1;
            fireTableRowsInserted(row, row);
        }

        public void remove(EmployeeDetails ed) {
            int row = rows.indexOf(ed);
            if (row < 0) {
                return;
            }
        }

        public void remove(int row) {
            if (row < 0 || row > rows.size()) {
                return;
            }
            rows.remove(row);
            fireTableRowsInserted(row, row);
        }
    }

    public class EmployeeDetails {

        String name;
        String address;
        String city;
        String zipcode;

        public EmployeeDetails(String name, String address, String city, String zipcode) {
            this.name = name;
            this.address = address;
            this.city = city;
            this.zipcode = zipcode;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setAddres(String address) {
            this.address = address;
        }

        public String getAddress() {
            return address;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCity() {
            return city;
        }

        public void setZip(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getZip() {
            return zipcode;
        }

        public String toString() {
            return name + " " + address + " " + city + " " + zipcode;
        }

    }

}