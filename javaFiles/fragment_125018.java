loginButton.setOnClickListener(new View.OnClickListener() {
    @Override

    public void onClick(View view) {

       String valueUN = editText1.getText().toString();
       String valuePW = editText2.getText().toString();
       if(valueUN.equals(userNameValue) && valuePW.equals(passwordValue)) {
           Toast.makeText(MainActivity.this, "Login was Successfully", Toast.LENGTH_SHORT).show();
       }
       else {
           Toast.makeText(MainActivity.this, "Username or password is incorrect", Toast.LENGTH_SHORT).show();
       }
    }
});