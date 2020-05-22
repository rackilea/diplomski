public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter amount in cents");
    double cents = input.nextInt();

    int numQuarters = cents / 25;
    int numDimes    = (cents % 25) / 10;
    int numNickels  = ((cents % 25) % 10) / 5;
    int numPennies  = ((cents % 25) % 10) % 5;

    System.out.println(quarters + " Quarters");
    System.out.println(dimes    + " Dimes");
    System.out.println(nickels  + " Nickels");
    System.out.println(pennies  + " Pennies");
}