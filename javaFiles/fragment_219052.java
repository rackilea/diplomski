Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a single integer");

    String integerPattern = "[+-]?\\d+$"; // positive or negative and digits only

    while(scanner.hasNext(integerPattern) == false) {
        String x = scanner.nextLine();// capture and discard input.
        System.out.println("Enter a single integer. '" + x + "' is an invalid input.");
    }
    int number = scanner.nextInt(); // capture input only if it matches pattern.
    scanner.close();
    System.out.println("number: " + number);