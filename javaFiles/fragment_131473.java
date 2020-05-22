public void buttonRegister(View view){
    EditText etUsername = (EditText) findViewById(R.id.etUsername);
    EditText etPassword = (EditText) findViewById(R.id.etPassword);
    final String username = etUsername.getText().toString();
    final String password = etPassword.getText().toString();


    User newUser = new User(username, password);
    newUser.save(new StackMobModelCallback() {

        @Override
        public void failure(StackMobException arg0) {
            // TODO Auto-generated method stub
            System.out.println("fail");
            YourActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(YourActivity.this, 
                                    "Fail", 
                                    Toast.LENGTH_SHORT).show();
                }
            }                
        }

        @Override
        public void success() {
            // TODO Auto-generated method stub
            System.out.println("success");
            YourActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(YourActivity.this, 
                                    "Success", 
                                    Toast.LENGTH_SHORT).show();
                }
            }
        }
    });
}