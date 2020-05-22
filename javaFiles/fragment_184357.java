@Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);

           //initialize first
                    mUserFirstname = (EditText) findViewById(R.id.firstNameRegisterEditText);
                    mUserLastname = (EditText) findViewById(R.id.lastNameRegisterEditText);
                    mUsername = (EditText) findViewById(R.id.userNameRegisterEditText);
                    mUserPassword = (EditText) findViewById(R.id.passwordRegisterEditText);
                    mUserEmail = (EditText) findViewById(R.id.emailRegisterEditText);
                    mUserPhonenumber = (EditText) findViewById(R.id.phoneNumberRegisterEditText);
                    mUserPostalcode = (EditText) findViewById(R.id.postalCodeRegisterEditText);
                    mGender = (RadioGroup) findViewById(R.id.radioGroup);
                    mMale = (RadioButton) findViewById(R.id.maleGenderRegisterEditText);
                    mFemale = (RadioButton) findViewById(R.id.femaleGenderRegisterEditText);
                    mDob = (EditText) findViewById(R.id.dateofBirthEditText);
                    mRegisterbutton = (Button) findViewById(R.id.registerButton);

      //listen to checked changes next
           mMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                   if (isChecked) {ParseUser user = new ParseUser();
                       user.put(COLUMN_GENDER, MALE);
                       user.saveInBackground(); // if you want to save immediately

                   }
               }
           });

            mFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {ParseUser user = new ParseUser();
                        user.put(COLUMN_GENDER, FEMALE);
                        user.saveInBackground(); // if you want to save immediately
                    }
                }
            });







                    //Listen to Register button click
                    mRegisterbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //toast

                            //get the username, password and email and convert to string

                            String username = mUsername.getText().toString().trim();
                            String password = mUserPassword.getText().toString().trim();
                            String email = mUserEmail.getText().toString().trim();
                            String firstname = mUserFirstname.getText().toString().trim();
                            String lastname = mUserLastname.getText().toString().trim();
                            String phonenumber = mUserPhonenumber.getText().toString().trim();
                            String postalcode = mUserPostalcode.getText().toString().trim();
                            String gender = mMale.isChecked() ? MALE : FEMALE;
                            //store user
                            ParseUser user = new ParseUser();
                            user.setUsername("my name");
                            user.setPassword("my pass");
                            user.setEmail("email@example.com");

    // other fields can be set just like with ParseObject
                            user.put("first name", "my name");
                            user.put("last name", "my name");
                            user.put("postal", "65055");
                            user.put("gender", "male or female");
                            user.put("dob", "mm/dd/yyyy");
                            user.put("phone", "650-253-0000");
                            user.put(COLUMN_GENDER, gender);

                            user.signUpInBackground(new SignUpCallback() {
                                @Override
                                public void done(ParseException e) {
                                    if (e==null) {
                                        //user signed up succesfully
                                        Toast.makeText(RegisterActivity.this,"Welcome To The Party...", Toast.LENGTH_LONG).show();

                                        //take user to homepage
                                    }else {
                                    // there was and error sigingup user. advise user
                                    }

                                }
                            });


                        }
                    });



                    });
                }