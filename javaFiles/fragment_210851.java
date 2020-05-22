Scanner scan;

    scan = new Scanner(System.in);
    int firstNumber = Integer.MIN_VALUE;
    int secondNumber = Integer.MIN_VALUE;

    while (firstNumber == Integer.MIN_VALUE) {
        System.out.print("Enter the first number to be added: ");
        if (scan.hasNextInt()) {
            firstNumber = scan.nextInt();
        } else {
            scan.next();
        }
    }

    while (secondNumber == Integer.MIN_VALUE) {
        System.out.print("Enter the second number to be added: ");
        if (scan.hasNextInt()) {
            secondNumber = scan.nextInt();
        } else {
            scan.next();
        }
    }

    if ((firstNumber != Integer.MIN_VALUE) && (secondNumber != Integer.MIN_VALUE)) {
        int sum = secondNumber + firstNumber;
        System.out.println("That equals: " + sum);
    }
    scan.close();