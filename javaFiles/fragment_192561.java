@Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);
            TextView RegisterHead=(TextView)findViewById(R.id.RegisterHeadline);
            RegisterHead.setTextSize(25);
            Button CompleteRegister=(Button)findViewById(R.id.CompleteRegisterBtn);
            final EditText RegisteredUser=(EditText)findViewById(R.id.RegisteredUser);
            final EditText RegisteredPass=(EditText)findViewById(R.id.RegisteredPass);
            final EditText RegisteredName=(EditText)findViewById(R.id.RegisteredFn);
            final EditText RegisteredPhone=(EditText)findViewById(R.id.RegisteredPhone);
            final EditText RegisteredID=(EditText)findViewById(R.id.RegisteredID);

            CompleteRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final String User2String=String.valueOf(RegisteredUser.getText());
                    final String Pass2String=String.valueOf(RegisteredPass.getText());
                    final String Name2String=String.valueOf(RegisteredName.getText());
                    final String Phone2String=String.valueOf(RegisteredPhone.getText());
                    final String ID2String=String.valueOf(RegisteredID.getText());

                    db=new MyDBHandler(this);



                    if(User2String.equals("")||Pass2String.equals("")|| Name2String.equals("")||Phone2String.equals("")||ID2String.equals("")){
                        Toast.makeText(RegisterActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                    else {

                        UserTable NewUser=new UserTable(User2String,Pass2String,Name2String,Phone2String,ID2String);
                        db.Add(NewUser);
                        Toast.makeText(RegisterActivity.this, "", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                }
            });
        }