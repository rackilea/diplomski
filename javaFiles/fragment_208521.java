Scanner doubleScan = new Scanner(System.in);
    double runningTotal = 0;
    do {
        System.out.print("Enter an amount (-1 to exit): ");
        double expense = doubleScan.nextDouble();
        if (expense != -1) runningTotal += expense;
    } while (expense != -1);
    System.out.println("Total: " + runningTotal);