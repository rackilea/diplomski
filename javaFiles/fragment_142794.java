submit.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View arg0) {

               String username = uname.getText().toString();
               String pass = password.getText().toString();
               new Login().execute(username, pass);

           }
       });
    }
    private void findViewsById() {

        uname = (EditText) findViewById(R.id.txtUser);
        password = (EditText) findViewById(R.id.txtPass);
        submit = (Button) findViewById(R.id.login);
    }
    private class Login extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... args) {
            // Getting username and password from user input

            String username = args[0];
            String pass = args[1];