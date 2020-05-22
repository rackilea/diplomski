for (User u: list) {
    if (u.getRole().equalsIgnoreCase("recruiter")) {

  //sysout

 if (u.getUserName().equalsIgnoreCase(userName) && u.getPassword().equalsIgnoreCase(password))
          //2 sysout
        return u;
     }
     break;      //here break statement will exit your loop just after first Iteration.
 }