import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class MainClass {

    JTextField name;
    JPasswordField pass;
    JButton submit;

    MainClass(){
        JFrame main = new JFrame("Login Form ");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        name = new JTextField(10);
        pass = new JPasswordField(10);

        JPanel gui = new JPanel(new BorderLayout(3,3));
        gui.setBorder(new EmptyBorder(5,5,5,5));
        main.setContentPane(gui);

        JPanel labels = new JPanel(new GridLayout(0,1));
        JPanel controls = new JPanel(new GridLayout(0,1));
        gui.add(labels, BorderLayout.WEST);
        gui.add(controls, BorderLayout.CENTER);

        labels.add(new JLabel("Username: "));
        controls.add(name);
        labels.add(new JLabel("Password: "));
        controls.add(pass);
        submit = new JButton("Submit");

        gui.add(submit, BorderLayout.SOUTH);
        main.pack();
        main.setVisible(true);
    }

    public static void main(String[] args) {
        MainClass mc = new MainClass();
    }
}