public static int checkMyInput () { 
    try {
        return myScanner.nextInt();
    } catch (InputMismatchException e ) {
         myScanner.next();
         System.out.println("bacon luff");
        return 0 ;
    }
}