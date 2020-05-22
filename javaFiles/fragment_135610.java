btnlogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final String id = etid.getText().toString();
            final String pwd = etpwd.getText().toString();


            if(Logined == 0) {

            //Simply allow user to login and write here code for logging.

            SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Logined", 1);
                editor.putString("SID", sid);//You have to get sid from somewhere.
                editor.commit();
            }
            else if(Logined == 1)
            {
                if(!sid.equals(sid2))//sid2 is a sid of user who is logging currently
                {
                    AlertDialog.Builder helpfriend = new AlertDialog.Builder(LoginActivity.this);
                helpfriend.setMessage("The login ID not same with the previous ID.Trying to help friend sign? Please contact your lecturer.")
                        .setNegativeButton("Close", null)
                        .create()
                        .show();
               }
               else
               {
                   //allow user for login and write code for logging.
               }
            }