if (userName == null || userName.isEmpty() || passString == null
            || passString.isEmpty()
            || !passString.equals(passStringConfirm)) {
    Border redLine = BorderFactory.createLineBorder(Color.red);
    enterUsername.setText("");
    enterPassword.setText("");
    enterConfirmPassword.setText("");
    enterUsername.setBorder(redLine);
    enterPassword.setBorder(redLine);
    enterConfirmPassword.setBorder(redLine);
}