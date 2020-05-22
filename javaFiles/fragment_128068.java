private static void processString(){

        String userInput; // The input by the user.

        System.out.println("This program checks to see if the user's input is a palindrome.");
        System.out.println("White space and non alphanumeric characters will be ignored.");
        System.out.println();
        System.out.print("Please enter a string: ");
        userInput = TextIO.getln(); // assigns the user input to a variable

        // subroutine strip is called and an the value of 
        // the variable userInput is passed
        str = strip(userInput);

       // subroutine reverse is called and an the value of 
       // the variable str is passed
       String rev = reverse(str);

       // compares the two objects
       if ( str.equals(rev) ) {
            System.out.println("This IS a palindrome");
        } 
        else {
            System.out.println("This NOT a palindrome");
        } // end of if statement


}