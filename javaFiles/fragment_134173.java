choice = sc.nextLine(); //make choice the next input


    while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"))
    { //start of while

        if (choice.isEmpty()) {
            System.out.println("Error! This entry is required. Try again."); //display error message when the user enters invalid response


       }


        else {
            System.out.println("Error! Entry must be 'y' or 'n'. Try again."); // display error message when the user enters no response
        }

        System.out.print ("Continue (y/n): "); //promt users for input
        choice = sc.next();
}