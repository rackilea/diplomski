int inputexception = 0;

do {
   inputexception = 0;

   try {

       System.out.println("What piece would you like to move?");           
       pieceselectioninput = scan.nextInt();

    } catch ( InputMismatchException e ){
        // Get the next line so it won´t repeat forever
        scan.nextLine();
        inputexception = 1;
    }
} while ( inputexception == 1 );