for (int i = 0; i < 5 ; i++ ) {
    if (myScanner.hasNextInt()) {
        x = myScanner.nextInt();
        if (x < 0) {
           System.out.println("Invalid input, enter again:"); 
        } else {
           sum += x;
        }
    } 
    else {
        // get whatever is on the scanner, since we know it isn't and int
        String crud  = s.next(); 
        System.out.println("Invalid input "+crud+" enter again:");
    }

}