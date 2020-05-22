public static void prompt_log_out(){
    System.out.println(); //prints out a blank line for easier readability
    System.out.println("Would you like to log out?  Please type \"y\" for Yes or \"n\" for No.");
    if ("y".equals(user_input.next())) {
        log_out = true;
    }
    // A quick and dirty fix
    user_input.nextLine()
}