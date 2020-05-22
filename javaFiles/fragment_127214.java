import javax.swing.*;

public class TestingJavaCode {

    public TestingJavaCode() {

        JFrame appFrame = new JFrame();
        JPanel loginPanel = new JPanel();
        appFrame.setSize(300, 130);
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.PAGE_AXIS));

        // Button for logging in, with respective GridBagConstraint
        // setFocusable is set to false to take out the border around the text
        JButton loginButton = new JButton("Login");
        loginButton.setFocusable(false);

        JPanel usernamePanel = new JPanel();
        // Username text-field and JLabel with respective GridBagConstraints
        JTextField tfUsername = new JTextField(15);
        JLabel txtUser = new JLabel("Username: ");

        usernamePanel.add(txtUser);
        usernamePanel.add(tfUsername);

        JPanel passwordPanel = new JPanel();
        // Password text-field and JLabel with respective GridBagConstraints
        JPasswordField tfPassword = new JPasswordField(15);
        JLabel txtPassword = new JLabel("Password: ");

        passwordPanel.add(txtPassword);
        passwordPanel.add(tfPassword);

        // Add all components to the JFrame
        // Making sure to add the text before the text-fields
        loginPanel.add(usernamePanel);

        loginPanel.add(usernamePanel);
        loginPanel.add(passwordPanel);
        loginPanel.add(loginButton);
        // Show the frame
        appFrame.add(loginPanel);
        appFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        appFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new TestingJavaCode();
    }

}