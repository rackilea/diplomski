login = new Login(getApplicationContext(), this); 
//this is an interface that i implements in Activity definition

loginButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            //execute() here, i cuted some not necesery code from here
            try {
                // im using get because i want to get valu from AsyncTask
                login.execute(email, password).get();
            }
            catch(Exception e){ }
}