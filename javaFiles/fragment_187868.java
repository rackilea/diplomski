Scanner scanPrice = new Scanner(System.in);
    System.out.println("Enter the cost: ");
    try {
        priceTag = scanPrice.nextDouble();
    } catch (InputMismatchException e) {
        System.out.println("Only numbers. Enter the cost again.");
        scanPriceException = new Scanner(System.in);
        priceTag = scanPriceException.nextDouble();
    }