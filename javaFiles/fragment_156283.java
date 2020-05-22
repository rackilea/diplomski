do {
    try {
        // menu to be displayed
        System.out.println("Menu");
        for( int i = 0; i < entries.length; ++i ){
            System.out.println((i+1) + "." + entries[i] );
        }
        System.out.println("Select option.");
        // request input from the user
        menuOption = menuScanner.nextInt();
        // if else statements to determine the user's answer
        if( 1 <= menuOption && menuOption <= entries.length ){
            System.out.println("You have selected " + entries.[menuOptions-1] );
        } else {
            System.out.println("Invalid selection" );
        }
    } catch (InputMismatchException inputMismatchException){
        // catch block
        menuScanner.nextLine();
        System.out.println("Numbers only please.");
    }
} while (menuOption != 5);