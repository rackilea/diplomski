while (true) {
    System.out.print("Enter current population or -1 to exit: ");
    currentPop = scan.nextDouble();

    if (currentPop == -1) {
        break;
    } else if (currentPop <= 0) {
        System.out.println("Population must be positive");
        continue; // restart the loop
    }

    System.out.print("Enter birth rate: ");

    ...
}
System.out.println("Done!");