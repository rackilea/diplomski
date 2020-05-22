public void doSubmit(View view) {
    boolean login_validation_result = false;
    EditText name, username, e_mail;
    EditText password, re_enter_pass;
    name = (EditText) findViewById(R.id.name);
    username = (EditText) findViewById(R.id.userName);
    password = (EditText) findViewById(R.id.password);
    e_mail = (EditText) findViewById(R.id.e_mail);
    login_validation_result = login_validation();
    if (login_validation_result==true){
        Toast.makeText(this, "Success ful", Toast.LENGTH_SHORT).show();
    }    
}