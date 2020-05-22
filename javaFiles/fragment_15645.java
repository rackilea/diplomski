import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Test extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTextField numberTextField;
    private JButton submitButton;

    public Test() {
        setTitle("Get Phone Number");
        setLayout(new FlowLayout());
        setSize(600, 300);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create TextField, Label and Button
        add(new JLabel("Search Phone Number:"));
        numberTextField = new JTextField(10);
        add(numberTextField);
        submitButton = new JButton("Search");
        add(submitButton);

        //Adding action listener to the button
        submitButton.addActionListener(this);

        setVisible(true);
        pack();
    }

    public static void main(String[] args) {
        new Test();
    }

    public void findNumber(String path, int number) {
        File file = new File(path);

        try {
            Scanner sc = new Scanner(file);

            while(sc.hasNextInt()) {
                int i = sc.nextInt();
                if(i == number) {
                    JOptionPane.showMessageDialog(null, "Phone Number: " + number + " is found!");
                    break;
                }
                else {
                    if(!sc.hasNextInt()) {
                        JOptionPane.showMessageDialog(null, "Sorry  phone number: " + number + " is not found!");
                        break;
                    }
                    continue;
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        findNumber("Customers.txt", Integer.parseInt(numberTextField.getText()));
    }
}