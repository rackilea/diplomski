public void login() {
    JPanel loginPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints(
            0, 0, 1, 1, 0, 0,
            GridBagConstraints.BASELINE_TRAILING,
            GridBagConstraints.NONE, 
            new Insets(5, 5, 5, 5), 4, 6);
    loginPanel.add(new JLabel("ID"), gbc);
    gbc.gridy = 1;
    loginPanel.add(new JLabel("Password"), gbc);
    gbc.anchor = GridBagConstraints.BASELINE_LEADING;
    gbc.gridx = 1;
    gbc.gridy = 0;
    loginPanel.add(new JTextField("enter ID", 10), gbc);
    gbc.gridy = 1;
    loginPanel.add(new JPasswordField(6), gbc);

    int result = JOptionPane.showConfirmDialog(
            ui, loginPanel, "LogIn", JOptionPane.OK_CANCEL_OPTION);
    if (result == JOptionPane.OK_OPTION) {
        // here a real app would check the results of the ID/password
        cardLayout.show(ui, "loggedin");
    }
}