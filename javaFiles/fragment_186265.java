import java.awt.*;
import javax.swing.*;

class MainClass {

    JTextField name;
    // This should be a JPasswordField!
    JTextField pass;
    JButton submit;

    MainClass(){
        JFrame main = new JFrame("Login Form ");
        // Don't use this nonsense!
        //main.setBounds(350,150,500,500);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        name = new JTextField(10);
        pass = new JTextField(10);
        main.setLayout(new GridLayout(0,1));
        JPanel pane = new JPanel(new GridLayout(0,1));
        main.add(pane);
        pane.add(new JLabel("Username: "));
        pane.add(name);
        pane.add(new JLabel("Password: "));
        pane.add(pass);
        submit = new JButton("Submit");
        pane.add(submit);
        //submit.addActionListener(new Handler());
        main.pack();
        main.setVisible(true);
    }

    public static void main(String[] args) {
        MainClass mc = new MainClass();
    }
}