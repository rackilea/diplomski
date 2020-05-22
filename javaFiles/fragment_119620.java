// Example command
    String command = "print balance";

    String[] commandSplitted = command.split(" ");

    // You have to add a length check for the array
    if (commandSplitted[0].equals("print")) {
        // command part 1 is print
        if (commandSplitted[1].equals("history")) {
            // command part 2 is history
            // command is print history
            // ...
            System.out.println("enter 4");
        } else if (commandSplitted[1].equals("balance")) {
            // command part 2 is balance
            // command is print balance
            // ...
            System.out.println("enter 3");
        }//... depending on the amount of commands you might want to use a switch case on the split parts
    } // else if ...