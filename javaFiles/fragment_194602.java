private static int readInputInt(String error, int max) {
    Scanner s = new Scanner(System.in);
    int result;
    while (true) { 
        if (s.hasNextInt()) {
            result = s.nextInt();    
            if (result <= max) {
                s.close();
                return result;
            }
         } else { //Only want to call next() if it doesn't meet the first conditional. We've already called next when it is an int. 
             s.next();
         }
         System.out.println(error);
    }