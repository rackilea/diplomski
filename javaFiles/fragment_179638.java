if (uName.getText().toString().equals("admin") && pass.getText().toString().equals("pass")) {
    Intent myIntent = new Intent(MainPage.this, TasksPanel.class);
    startActivity(myIntent);
    finish();
} else {
    Toast.makeText(getApplicationContext(), "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
}