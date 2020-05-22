import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

public class PassTable {

    public static void main(String[] args) {
        new PassTable();
    }

    public PassTable() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
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

        private ExampleTable example;

        public TestPane() {
            setLayout(new BorderLayout());
            example = new ExampleTable();
            add(example);
            JButton add = new JButton("Add");
            add(add, BorderLayout.SOUTH);
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    LinkedList<Person> people = new LinkedList<Person>();
                    people.add(new Person("A", "A", 1));
                    people.add(new Person("B", "B", 2));
                    people.add(new Person("C", "C", 3));
                    people.add(new Person("D", "D", 4));
                    example.setPeople(people);
                }
            });
        }

    }

    public class ExampleTable extends JPanel {

        private JTable table;

        public ExampleTable() {
            this(new LinkedList<Person>());
        }

        public ExampleTable(LinkedList<Person> people) {
            setLayout(new BorderLayout());
            table = new JTable(new SampleTableModel(people));
            add(new JScrollPane(table));
        }

        public void setPeople(LinkedList<Person> people) {
            table.setModel(new SampleTableModel(people));
        }

    }

    public class SampleTableModel extends AbstractTableModel {

        private LinkedList<Person> data;

        public SampleTableModel(LinkedList<Person> data) {
            this.data = data;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public String getColumnName(int column) {
            String name = "";
            switch (column) {
                case 0:
                    name = "First name";
                    break;
                case 1:
                    name = "Last name";
                    break;
                case 2:
                    name = "Age";
                    break;
            }
            return name;
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Object value = null;
            Person person = data.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    value = person.getFirstName();
                    break;
                case 1:
                    value = person.getLastName();
                    break;
                case 2:
                    value = person.getAge();
                    break;
            }
            return value;
        }

    }

    public class Person {
        private String firstName;
        private String lastName;
        private int age;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

    }

}