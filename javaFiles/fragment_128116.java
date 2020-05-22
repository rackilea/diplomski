// inports here....

@SuppressWarnings("serial")
public class GetUserInfo extends JPanel {
    private static final Insets INSETS = new Insets(4, 4, 4, 4);
    private JTextField nameField = new JTextField(10);
    private JPasswordField passField = new JPasswordField(10);

    public GetUserInfo() {
        // gridbaglayout works well for your needs
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = INSETS;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JLabel("Name:"), gbc);
        gbc.gridy = 1;
        add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(nameField, gbc);
        gbc.gridy = 1;
        add(passField, gbc);
    }

    // allow classes to query this JPanel for the user name 
    public String getName() {
        return nameField.getText();
    }

    // and password data
    public char[] getPass() {
        return passField.getPassword();
    }

}