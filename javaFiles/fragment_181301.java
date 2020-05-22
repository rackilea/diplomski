public static String next() {
    Scanner input = new Scanner(System.in);
    System.out.print("How many days are you going to spend travelling?");
    String days = input.nextLine();
    System.out.print("How much money in USD are you planning to spend on your trip?");
    String budget = input.nextLine();
    System.out.print("What is the three letter currency symbol for your travel destination?");
    String currency = input.nextLine();
    System.out.print("How many " + currency + " are there in 1 USD?");
    String currencyConversion = input.nextLine();
    return days;
}