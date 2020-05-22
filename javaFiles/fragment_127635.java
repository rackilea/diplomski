import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Main {

    public class Person {

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public class Producer extends Thread {
        private Model model;

        public Producer(Model model) {
            this.model = model;
        }

        @Override
        public void run() {
            Random random = new Random();
            Person fred = new Person("Fred Flintstone", 37);
            Person wilma = new Person("Wilma Flintstone", 18);
            Person pebbles = new Person("Pebbles Flintstone", 15);
            Person dino = new Person("Dino Flintstone", 45);
            Person barney = new Person("Barney Rubble", 76);
            Person betty = new Person("Betty Rubble", 76);
            Person bamm = new Person("Bamm-Bamm Rubble", 76);
            while (true) {
                try {
                    model.addPerson(fred);
                    Thread.sleep(1500);
                    model.addPerson(wilma);
                    Thread.sleep(1500);
                    model.addPerson(pebbles);
                    Thread.sleep(1500);
                    model.addPerson(dino);
                    Thread.sleep(1500);
                    model.addPerson(barney);
                    Thread.sleep(1500);
                    model.addPerson(betty);
                    Thread.sleep(1500);
                    model.addPerson(bamm);
                    while (model.getPeople().size() > 0) {
                        Person p = model.getPeople().get(random.nextInt(model.getPeople().size()));
                        model.removePerson(p);
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class Model {
        private static final String PEOPLE = "people";

        private List<Person> people;

        private PropertyChangeSupport propertyChangeSupport;

        public Model() {
            people = new ArrayList<Person>();
            propertyChangeSupport = new PropertyChangeSupport(this);
        }

        public PropertyChangeSupport getPropertyChangeSupport() {
            return propertyChangeSupport;
        }

        public List<Person> getPeople() {
            return people;
        }

        public void addPerson(Person aPerson) {
            people.add(aPerson);
            System.out.println("Person object added to people list:" + aPerson);
            getPropertyChangeSupport().firePropertyChange(PEOPLE, null, aPerson);
        }

        public void removePerson(Person aPerson) {
            people.remove(aPerson);
            getPropertyChangeSupport().firePropertyChange(PEOPLE, aPerson, null);
        }
    }

    public class View extends JFrame implements PropertyChangeListener {
        private JPanel topPanel, botPanel;
        private JList peopleList;
        private JScrollPane scrollPane;
        private Model model;
        private DefaultListModel peopleListModel;

        public View(Model model) {
            this.model = model;
            setSize(200, 220);
            setTitle("View");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            topPanel = new JPanel();
            botPanel = new JPanel();
            peopleListModel = new DefaultListModel();
            for (Person p : model.getPeople()) {
                peopleListModel.addElement(p);
            }
            peopleList = new JList(peopleListModel);
            model.getPropertyChangeSupport().addPropertyChangeListener(Model.PEOPLE, this);
            scrollPane = new JScrollPane(peopleList);
            topPanel.setLayout(new GridLayout(1, 1));
            topPanel.add(scrollPane);
            topPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "People list"));

            Container cp = getContentPane();
            cp.add(topPanel, BorderLayout.NORTH);
            cp.add(botPanel, BorderLayout.SOUTH);
        }

        @Override
        public void propertyChange(final PropertyChangeEvent evt) {
            if (!SwingUtilities.isEventDispatchThread()) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        propertyChange(evt);
                    }
                });
                return;
            }
            if (evt.getSource() == model) {
                if (Model.PEOPLE.equals(evt.getPropertyName())) {
                    if (evt.getOldValue() != null && evt.getNewValue() == null) {
                        peopleListModel.removeElement(evt.getOldValue());
                    } else if (evt.getOldValue() == null && evt.getNewValue() != null) {
                        peopleListModel.addElement(evt.getNewValue());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Main().init();
    }

    private void init() {
        final Model model = new Model();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View theView = new View(model);
                theView.setVisible(true);
            }
        });
        Producer producer = new Producer(model);
        producer.start();
    }
}