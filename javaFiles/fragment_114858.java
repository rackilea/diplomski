if (userName == null || userName.isEmpty() || passString == null
            || passString.isEmpty()
            || !passString.equals(passStringConfirm)) {
    enterUsername.setText("");
    enterPassword.setText("");
    enterConfirmPassword.setText("");
}