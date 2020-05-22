System.out.print("Password : ");
    inputPassword = input.next();


   if(passCheck(inputPassword))
    {
    System.out.print("Please confirm your password : ");
    confirmPassword = input.next();


          if(inputPassword.matches(confirmPassword)){
           System.out.println("Password successfully created.");
          } else {
          System.out.println("Passwords do not match.");
           }
    }
    else {....}