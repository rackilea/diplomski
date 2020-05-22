public static boolean safeToUse(String plaintext) {
    Scanner myScanner = new Scanner(System.in);
    plaintext = myScanner.nextLine();
    String upper = plaintext.toUpperCase();
        for (int i=0; i<upper.length(); i++) {
            char c = upper.charAt(i);
                if (c < FIRST && c > LAST) {
                    myScanner.close(); //Close the scanner before you return true
                    return true;
                }
        }
    myScanner.close(); //close the scanner before you return.
    return false;
}