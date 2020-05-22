public void checkInfo() {
    email = emailText.getText().toString().trim();
    password = passwordText.getText().toString().trim();

    if (TextUtils.isEmpty(email)) {
        Toast.makeText(this, "Email is required!",
                Toast.LENGTH_SHORT).show();
    } else if (TextUtils.isEmpty(password)) {
        Toast.makeText(this, "Password is required!",
                Toast.LENGTH_SHORT).show();
    } else {
        registerUser();
    }
}