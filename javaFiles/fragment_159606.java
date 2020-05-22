@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    counter = 0;

    username = (EditText)findViewById(R.id.getEmail);
    password = (EditText)findViewById(R.id.getPassword);        

    login.setOnClickListener(new View.OnClickListener() {       
        public void onClick (View v) {
            if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                success = "Successful";
                counter = 0;
               sendMessage(v);
            } else {
                    counter++;
                    login.setText("Unsuccessful. Try again. " + 3-counter + " tries left.");
            }   
        }   
    });

 public void sendMessage (View view){
                        Intent intent = new Intent("com.example.linked1n.SCREENAFTLOG");
                        startActivity(intent);
                    }