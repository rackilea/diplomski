private Button butTotalNumQuick = new Button();

...

public void login() {

    ...

    if ((loginBox.getText() == "1234") && passwordBox.getText() == "1234") {
                    final HTML loginSuccessMsg = new HTML("Logged in. Please wait...");
                    db.add(loginSuccessMsg);
                    loggedIn = true;

                    butTotalNumQuick.setEnabled(loggedIn)
                }
}