public void register() {
    initialize();
    if (!validate()) {
        Toast.makeText(this, "Failed to create account.", Toast.LENGTH_SHORT).show();
    } else {
        If (db.insertUser(emailAdd,passwd)) {
            onSignupSuccess();
        } else {
            Toast.makeText(this, "Failed to create account (insert into database did not insert a row.).", Toast.LENGTH_SHORT).show();
        }
    }
}