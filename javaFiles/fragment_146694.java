int reties=3;
while (userName.equals("griffin.keyes")&&retires!=0) {       //multiple users names (keep condition like this)
    System.out.println("Enter password: ");      //easier method?--Not sure what that means
    userPassword = scnr.next();                  //to be looked into
    if (userPassword.equals("alphabet soup")){
        System.out.println("Hello, Zookeeper!"); //broken up to increase readability
        System.out.print("As zookeeper, you have access to all");
        System.out.print(" of the animals' information and their");
        System.out.print("daily monitoring logs. This allows you to");
        System.out.print(" track their feeding habits, habitat");
        System.out.println(" conditions, and general welfare.");
        break;
    }
    else {
        System.out.println("Login failed");     //Fixed
        System.out.println("Enter password: "); //3x Done 
        userPassword = scnr.next();             
        retries--;
    }
}