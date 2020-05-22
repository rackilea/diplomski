Login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        getuser_login_details();

            disable_all_views();

            Activate_wait_bar();

           final Database login = new Database();

           boolean decision = login.sign_in(user_name_password[0], user_name_password[1], new OnCompleteListener{
               @Override
               public void onComplete(){
                    System.out.println("here 3");
               }
           });

        }
    });