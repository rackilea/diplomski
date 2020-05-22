package stackoverflow.test;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AbstractJPanel extends JPanel implements CommonFields {

    private static final long serialVersionUID = 150030761086805569L;

    private JTextField nameField = null;
    private JTextField lastNameField = null;
    private JTextField ageField = null;
    private JLabel nameLabel = null;
    private JLabel lastNameLabel = null;
    private JLabel ageLabel = null;


    public AbstractJPanel() {
        super(new GridLayout(0, 2));

        nameField = new JTextField();
        lastNameField = new JTextField();
        ageField = new JTextField();

        nameLabel = new JLabel("Name: ");
        lastNameLabel =new JLabel("Last Name: ");
        ageLabel = new JLabel("Age: ");

        add(nameLabel);
        add(nameField);
        add(lastNameLabel);
        add(lastNameField);
        add(ageLabel);
        add(ageField);
    }

    public void setName(String name) {
        nameField.setText(name);
    }

    public void setLastName(String lastName) {
        lastNameField.setText(lastName);
    }

    public void setAge(int age) {
        ageField.setText(""+age);
    }

    public String getName() {
        return nameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public int getAge() {
        return Integer.parseInt(ageField.getText());
    }
}