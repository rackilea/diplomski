if(username.getText().toString().equals("admin") &&
        password.getText().toString().equals("admin")){
    Toast.makeText(getApplicationContext(), "Redirecting...",
            Toast.LENGTH_SHORT).show();
    Intent i = new Intent(login.this, your_new_activity_name.class);
    startActivity(i);

}