...
grid.add(actiontarget, 1, 6);

btn.setOnAction(evt -> {
    String user = userTextField.getText().trim();
    String password = pwField.getText().trim();

    if (!(user.isEmpty() || password.isEmpty())) {
        actiontarget.setFill(Color.GREEN);
        actiontarget.setText("Login succesfull");
    } else {
        actiontarget.setFill(Color.FIREBRICK);
        if (user.isEmpty()) {
            actiontarget.setText(password.isEmpty() ? "Please provide login and password!" : "No login provided!");
        } else {
            actiontarget.setText("Please provide a password!");
        }
    }
});