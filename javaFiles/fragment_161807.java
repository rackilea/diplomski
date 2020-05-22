// Prompt the user
System.out.println("Please enter an email address");

String emailAddress =  // read in their email adress 

while(!emailAddress.contains("@") || !emailAddress.contains(".")) {
    System.out.println("You have entered an invalid email address, please enter another.");

    emailAddress = // read in their email address again
}

// Email address now contains "@" and "."