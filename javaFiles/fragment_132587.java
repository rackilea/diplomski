public static int getInt(Scanner sc, String askMsg) {
    System.out.println(askMsg);
    while (!sc.hasNextInt()) {
        System.out.println("That's not a number. Please try again");
        sc.next(); // consuming incorrect token
    }
    //here we know that next value is proper int so we can safely 
    //read and return it
    return sc.nextInt();
}