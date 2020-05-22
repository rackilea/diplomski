LoginActivity.java

DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
String email_id = email.getText().toString();
boolean dbHelper.isExist(email_id);

// if record is exist then it will return true otherwise this method returns false