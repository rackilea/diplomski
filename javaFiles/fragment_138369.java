boolean isError = false; 

 if(inputFirstName.getText().toString().length() <= 0)
            {
                inputFirstName.setError("First name required!");
                isError = true;
            }
            if (inputLastName.getText().toString().length() < 0)
            {
                inputLastName.setError("Last name required!");
                isError = true;
            }
            if (inputEmail.getText().toString().length() == 0)
            {
                inputEmail.setError( "Valid email address required!" );
                isError = true;
            }
            if (inputPassword.getText().toString().length() < 8)
            {
                inputPassword.setError( "Password required! (Minimum of 8 characters." );
                isError = true;
            }
            if (!inputPassword2.getText().toString().equals(inputPassword.getText().toString()))
            {
                inputPassword.setError( "Passwords do not match! (Minimum of 8 characters.");

                inputPassword2.setError("Passwords do not match! (Minimum of 8 characters.");
                 isError = true;
            }

   if(isError){
       return;
   }