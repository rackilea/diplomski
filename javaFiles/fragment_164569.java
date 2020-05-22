if(fullName.indexOf(" ")==-1 || (fullName.indexOf(" ") == fullName.lastIndexOf(" "))){
    // The first check is to check if only firstname was given and the second check is to check if only first and middle names were given.
    // If first + middle is a valid scenario, you can remove the second half of the if condition
    System.out.println("error, incorrect input");
    System.exit(0);
}