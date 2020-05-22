protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);


person = new Person();

userName = (EditText) findViewById(R.id.user_name);
password = (EditText) findViewById(R.id.password);
email = (EditText) findViewById(R.id.email);
phone = (EditText) findViewById(R.id.phone);
submit = (Button) findViewById(R.id.submit);

submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       person.setUserName(userName.getText().toString());

       person.setPassword(password.getText().toString());

       person.setEmail(email.getText().toString());

       person.setPhone(phone.getText().toString());

        new JsonDataConverter().execute(person);
    }
 });
}