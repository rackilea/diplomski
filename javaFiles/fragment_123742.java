import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.FilterList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.TextFilterator;
import ca.odell.glazedlists.event.ListEvent;
import ca.odell.glazedlists.event.ListEventListener;
import ca.odell.glazedlists.gui.TableFormat;
import ca.odell.glazedlists.matchers.ThreadedMatcherEditor;
import ca.odell.glazedlists.swing.EventTableModel;
import ca.odell.glazedlists.swing.TextComponentMatcherEditor;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TextFilterCount {


    private EventList<Person> eventList = new BasicEventList<Person>();

    public TextFilterCount() {
        setupGui();
        populateTable();
    }

    private void populateTable() {
        eventList.add(new Person("Charles", "Dickens"));
        eventList.add(new Person("George", "Orwell"));
        eventList.add(new Person("John", "Steinbeck"));
        eventList.add(new Person("Jospeh", "Heller"));
    }

    private void setupGui() {
        JFrame frame = new JFrame("GlazedListed TextFilter count example");

        final JLabel countLabel = new JLabel();

        frame.setSize(600, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField();

        SortedList sortedList = new SortedList(eventList);

        TextFilterator<Person> personFilterator = new TextFilterator<Person>() {
            @Override
            public void getFilterStrings(List baseList, Person person) {
                baseList.add(person.getFirstName());
                baseList.add(person.getLastName());
            }
        };

        TextComponentMatcherEditor matcherEditor = new TextComponentMatcherEditor(textField, personFilterator);
        final FilterList filteredList = new FilterList(sortedList, new ThreadedMatcherEditor(matcherEditor));

        filteredList.addListEventListener(new ListEventListener() {

            @Override
            public void listChanged(ListEvent le) {
                System.out.println("List changed.");
                countLabel.setText("" + filteredList.size());
            }
        });

        String[] propertyNames = new String[] {"firstName", "lastName"};
        String[] columnLabels = new String[] {"First name", "Last name"};

        TableFormat tf = GlazedLists.tableFormat(Person.class, propertyNames, columnLabels);
        JTable table = new JTable(new EventTableModel(filteredList, tf));

        JPanel mainPanel = new JPanel(new BorderLayout());

        mainPanel.add(textField, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);

        mainPanel.add(countLabel, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }


    public class Person implements Comparable<Person> {
        private String firstName = "";
        private String lastName = "";

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public int compareTo(Person p) {
            if (this.getLastName().equals(p.getLastName())) {
                return this.getFirstName().compareTo(p.getFirstName());
            }

            return this.getLastName().compareTo(p.getLastName());
        }   
    }

    public static void main(String[] args) {
        new TextFilterCount();
    }
}