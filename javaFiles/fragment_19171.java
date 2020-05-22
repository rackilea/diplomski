import java.awt.EventQueue;
    import javax.swing.JFrame;
    import javax.swing.JButton;
    import javax.swing.JPanel;
    import javax.swing.JTextField;
    import javax.swing.border.LineBorder;
    import java.awt.Color;
    import javax.swing.JComboBox;
    import java.awt.event.ActionListener;
    import java.util.ArrayList;
    import java.awt.event.ActionEvent;

    public class comboTest {

        private JFrame frame;
        private JTextField name;
        private JTextField age;
        private JTextField ageField;
        private JTextField txtName;
        private JTextField txtAge;
        private JTextField txtAgeFromPerson;
        private ArrayList<Person> persons = new ArrayList<Person>();

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        comboTest window = new comboTest();
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        /**
         * Create the application.
         */
        public comboTest() {
            initialize();
        }

        /**
         * Initialize the contents of the frame.
         */
        private void initialize() {
            frame = new JFrame();
            frame.setBounds(100, 100, 473, 323);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);


            //Panel that contains name field and age field
            JPanel panel = new JPanel();
            panel.setBorder(new LineBorder(new Color(0, 0, 0)));
            panel.setBounds(144, 94, 175, 119);
            frame.getContentPane().add(panel);
            panel.setLayout(null);

            //TextField name where the user will write his/her name
            name = new JTextField();
            name.setBounds(79, 26, 86, 20);
            panel.add(name);
            name.setColumns(10);

            //TextField age where the user will write his/her age
            age = new JTextField();
            age.setBounds(79, 57, 86, 20);
            panel.add(age);
            age.setColumns(10);

            //Simple text - it does not interfere with the code
            txtName = new JTextField();
            txtName.setEditable(false);
            txtName.setText("Name");
            txtName.setBounds(5, 26, 69, 20);
            panel.add(txtName);
            txtName.setColumns(10);

            //Simple text - it does not interfere with the code
            txtAge = new JTextField();
            txtAge.setText("Age");
            txtAge.setEditable(false);
            txtAge.setBounds(5, 57, 69, 20);
            panel.add(txtAge);
            txtAge.setColumns(10);

            //Creating ComoboBox
            JComboBox comboB = new JComboBox();
            comboB.setBounds(10, 32, 105, 20);
            frame.getContentPane().add(comboB);

            //This is where the text (age) from the Jpanel will go to
            ageField = new JTextField();
            ageField.setEditable(false);
            ageField.setBounds(108, 111, 33, 20);
            frame.getContentPane().add(ageField);
            ageField.setColumns(10);

            //Adding name to ComboBow
            JButton btnAdd = new JButton("Add");
            btnAdd.setBounds(179, 224, 89, 23);
            frame.getContentPane().add(btnAdd);
            btnAdd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                        //the problem you had was, that you didnt save the age of the person you added, so i created the class Person(it is at the bottom of the file), which saves a name and an age
                        Person person = new Person(name.getText(),age.getText());//we create a person with the given name and age
                        comboB.addItem(person);//and add this person to the combo.
                        //we can add ANY Object to the combo, the combo will write the return of the toString method of the given object, so i have overridden the toString Method of the Person class to return the Persons name.
                    }
            });

            //this is the comboBox actionListener, but I don't know what to write here
            comboB.addActionListener(new ActionListener (){
                public void actionPerformed (ActionEvent e) {
                    Person person = (Person)comboB.getSelectedItem();//here we get the selected object from the combo and cast it to a Person Object since we know it is a person and we have to get the persons age
                    ageField.setText(person.getAge());//then we get the Persons age, and put it into the Textfield that is supposed to show the selected Persons age
                }
            });

            //Simple text - it does not interfere with the code
            txtAgeFromPerson = new JTextField();
            txtAgeFromPerson.setEditable(false);
            txtAgeFromPerson.setText("Age from person:");
            txtAgeFromPerson.setBounds(4, 111, 101, 20);
            frame.getContentPane().add(txtAgeFromPerson);
            txtAgeFromPerson.setColumns(10);
        }
    }

    class Person{// a simple class that stores a name and an age
        private String name, age;

        public Person(String name,String age){// usually the age would be stored in an int, but i used a string so we dont have to convert it when we read it from the textfield and when we put it into a textfield. So it is just for simplicitys sake
            this.name = name;
            this.age = age;
        }

        public String getAge(){
            return age;
        }

        public String getName(){
            return name;
        }

        public String toString(){
            return this.name;
        }
    }