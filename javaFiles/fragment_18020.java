int inputexception = 0;

do {

inputexception = 0;

    try {

        System.out.println("What piece would you like to move?");     
        String input = scan.nextLine();
        pieceselectioninput = Integer.parseInt(input);

    } catch ( NumberFormatException e ){
        inputexception = 1;
    }
} while ( inputexception == 1 );