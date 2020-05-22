for (User u: list) {
    if (u.getRole().equalsIgnoreCase("recruiter")) {

  //sysout

 if (u.getUserName().equalsIgnoreCase(userName) && u.getPassword().equalsIgnoreCase(password)){
          //2 sysout
        return u;
    } else{
               //your code if password doesnot matched
       }
      // continue even if more than one recruiter type User Object are in Database.
     }else{
               //your code if user Role doesnot matched
       }

 }   //loop will check all element present in that array. and if it's ROLE is  matched like "Recuriter" then it will check user and password.