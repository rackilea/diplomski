try {
    boolean loggedIn = usernamecheck.checkLogin(jtfUsername.getText(), jtfPassword.getText());
    if (!loggedIn) {
        displayErrorMessage("Sorry, wrong credentials");
        return;
    }
}
catch (SQLException se) {
    e.printStackTrace();
    displayErrorMessage("Sorry, couldn't check your credentials. Check the logs and report the problem to an administrator.");
    return;
}