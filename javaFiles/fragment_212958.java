public void sendLogin (View loginview){
    Intent i = new Intent(this, NetworkService.class);
    i.putExtra("username", usernameText.getText().toString());
    i.putExtra("password", passwordText.getText().toString());
    startService(i);
}