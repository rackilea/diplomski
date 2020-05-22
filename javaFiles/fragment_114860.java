if(userName == null || userName.isEmpty() || passString == null
        || passString.isEmpty() || !passString.equals(passStringConfirm)) {
    enterUsername.setText("");
    enterPassword.setText("");
    enterConfirmPassword.setText("");
    Border redLine = BorderFactory.createLineBorder(Color.red);
    enterUsername.setBorder(redLine);
    enterPassword.setBorder(redLine);
    enterConfirmPassword.setBorder(redLine);
    repaint();
} else { // <-- add this
    super.dispose();
    int response = 0;
    String firstDesposit = JOptionPane.showInputDialog(
            "Welcome " + userName + ". Enter your initial deposit.");
    initialDeposit = Double.parseDouble(firstDesposit);
    if (response == JOptionPane.OK_OPTION) {
        new Menu();
    }
}