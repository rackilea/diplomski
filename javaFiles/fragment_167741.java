AppUtils utils=new AppUtils(UserInformation.this);

editTextUsername = (EditText) findViewById(R.id.editTextName);
editTextEmail = (EditText) findViewById(R.id.editTextEmail);

editTextUsername.setText(utils.getUserName());