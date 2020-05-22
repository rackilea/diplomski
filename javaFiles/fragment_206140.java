import java.awt.BorderLayout;
import javax.swing.*;

public class MainMenu {
    private CustomerForm customerForm;

    public static void main(String[] arguments) {
        SwingUtilities.invokeLater(() -> new MainMenu().createAndShowGui());
    }

    private void createAndShowGui() {
        JFrame frame = new JFrame("Stack Overflow");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        String[] comboBoxItems = {"one", "two", "three"};
        JComboBox<String> jComboBox1 = new JComboBox<>(comboBoxItems);
        panel.add(jComboBox1, BorderLayout.NORTH);
        JButton button = new JButton("Do it!");
        panel.add(button, BorderLayout.SOUTH);
        frame.getContentPane().add(panel);

        Database database = new Database();
        customerForm = new CustomerForm(database, jComboBox1);

        button.addActionListener(actionEvent -> customerForm.doSomething());

        frame.setVisible(true);
    }
}


class CustomerForm {
    private Database database;
    private JComboBox<String> comboBox;

    public CustomerForm(Database database, JComboBox<String> comboBox) {
        this.database = database;
        this.comboBox = comboBox;
    }

    public void doSomething() {
        System.out.println();
        System.out.println("CustomerForm.doSomething");
        System.out.println("database: " + database);

        System.out.println("comboBox.getSelectedItem().toString(): "
                           + comboBox.getSelectedItem().toString());
    }
}


class Database {
}