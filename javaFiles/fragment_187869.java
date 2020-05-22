Scanner scanPrice = new Scanner(System.in);
    while (true) {
        System.out.println("Enter the cost: ");
        try {
            priceTag = scanPrice.nextDouble();
            break;
        } catch (InputMismatchException e) {
            System.out.println("Only numbers. Enter the cost again.");
            scanPrice.next();
        }
    }