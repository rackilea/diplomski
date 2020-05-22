import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.*;

public class TableFun extends JPanel {
    public static final String[] COL_NAMES = { "First Name", "Last Name", "E-mail", "Telephone" };
    private MyTableModel2 model = new MyTableModel2(COL_NAMES);
    private JTable myTable = new JTable(model);

    public TableFun() {
        JButton addPersonBtn = new JButton(new AddPersonAction("Add Person"));
        JPanel btnPanel = new JPanel();
        btnPanel.add(addPersonBtn);

        setLayout(new BorderLayout());
        add(new JScrollPane(myTable));
        add(btnPanel, BorderLayout.PAGE_END);
    }

    private class AddPersonAction extends AbstractAction {
        public AddPersonAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = "John";
            String surname = "Smith";
            String address = "Foo Street";
            String telephone = "222-222-5555";
            model.addRow(new Person(name, surname, address, telephone));
        }
    }

    private static void createAndShowGui() {
        TableFun mainPanel = new TableFun();

        JFrame frame = new JFrame("Table Fun");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private class MyTableModel2 extends DefaultTableModel {
        public MyTableModel2(String[] columnNames) {
            super(columnNames, 0);
        }

        public void addRow(Person person) {
            Object[] rowData = new Object[4];
            rowData[0] = person.getName();
            rowData[1] = person.getSurname();
            rowData[2] = person.getMail();
            rowData[3] = person.getTelephone();            
            super.addRow(rowData);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (getRowCount() > 0) {
                Object value = getValueAt(0, columnIndex);
                if (value != null) {
                    return value.getClass(); 
                }
            }
            return super.getColumnClass(columnIndex);
        }
    }
}

class Person {
    private String name;
    private String surname;
    private String mail;
    private String telephone;

    public Person(String n, String s, String m, String t) {
        name = n;
        surname = s;
        mail = m;
        telephone = t;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    public String getTelephone() {
        return telephone;
    }


}