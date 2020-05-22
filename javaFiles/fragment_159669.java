public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    final double SHIRT_PRICE = 19.95;

    double shirt = SHIRT_PRICE;

    // Get number of shirts purchased.
    System.out.println("Enter the number of shirts "
            + "you have purchased to see your discount. ");

    int shirts = input.nextInt();

    double discount;
    switch (shirts) {

    case 1:
        discount = 0.0;
        break;
    case 2:
        discount = 0.0;
        break;
    case 3:
        discount = .10;
        break;
    case 4:
        discount = .10;
        break;
    case 5:
        discount = .20;
        break;
    case 6:
        discount = .20;
        break;
    case 7:
        discount = .20;
        break;
    case 8:
        discount = .30;
        break;
    case 9:
        discount = .30;
        break;
    case 10:
        discount = .30;
        break;
    case 11:
        discount = .30;
        break;
    case 12:
        discount = .40;
        break;
    default:
        discount = .40;
        break;

    }
    double finalDiscount = (shirt * shirts) * (1.0 - discount);

    System.out.println("Your discount is " + discount);
    System.out.println("Your total is " + finalDiscount);

    System.exit(1);

}