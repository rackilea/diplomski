JPanel pnlDetails = new JPanel(new GridBagLayout());
JTextField userNameField = new JTextField(10);
JPasswordField passwordField = new JPasswordField(10);

GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
gbc.anchor = GridBagConstraints.WEST;
gbc.insets = new Insets(2, 2, 2, 2);

pnlDetails.add(new JLabel("User name:"), gbc);
gbc.gridy++;
pnlDetails.add(new JLabel("Password:"), gbc);

gbc.gridx = 1;
gbc.gridy = 0;
gbc.anchor = GridBagConstraints.EAST;
pnlDetails.add(userNameField, gbc);
gbc.gridy++;
pnlDetails.add(passwordField, gbc);

// The result from the dialog, will be OK or CANCEL
int operation;
// Flag used to determine if the credentials are okay or not
boolean badCredentials = true;
do {

    operation = JOptionPane.showConfirmDialog(null, pnlDetails, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

    String userName = userNameField.getText();
    char[] password = passwordField.getPassword();

    // You would valid you credintals here :P
    if (userName.equals("super") && new String(password).equals("happy")) {

        badCredentials = false;

    } else if (operation != JOptionPane.CANCEL_OPTION) {

        JOptionPane.showMessageDialog(null, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);

    }

} while (operation != JOptionPane.CANCEL_OPTION && badCredentials);

if (!badCredentials && operation != JOptionPane.CANCEL_OPTION) {

    System.out.println("Continue program");

} else {

    System.out.println("Exit program");

}

System.exit(0);