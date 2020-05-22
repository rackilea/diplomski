public void login(View view){
if(username.getText().toString().equals("admin") &&
        password.getText().toString().equals("admin")){
    Toast.makeText(getApplicationContext(), "Redirecting...",
            Toast.LENGTH_SHORT).show();
startActivity(new Intent(MainActivity.this, Home.class));
}
else{
    Toast.makeText(getApplicationContext(), "Wrong Credentials",
            Toast.LENGTH_SHORT).show();
    attempts.setBackgroundColor(Color.RED);
    counter--;
    attempts.setText(Integer.toString(counter));
    if(counter==0){
        login.setEnabled(false);
    }

}