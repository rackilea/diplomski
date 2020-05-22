public void loginUsingUsernameAndPassword(String username, String password, String pageType) {
    LoginPageUi ui = getUi(pageType);
    if (ui != null) {
        ui.username.waitForToBeDisplayed();
        ui.username.setValue(username);
        ui.password.setValue(password);
        ui.loginButton.click();
    }
}