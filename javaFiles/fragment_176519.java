public static void main(String[] args) {
    System.out.println("Would you like to calculate simple interest or compound interest?");
    userInputStr = myScanner.next();

    System.out.println(userInputStr); // !!

    if (userInputStr.equalsIgnoreCase("simple interest")) {
        // .... do some stuff
    } else if (userInputStr.equalsIgnoreCase("compound interest")) {
        // .... do other stuff
    }
}