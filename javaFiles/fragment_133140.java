do {
    System.out.println("Select operation (1-5): ");
    choice = -1;
    if (!sc.hasNextInt()) {
        System.out.println("Please enter a number (1-5, inclusive)");
    } else {
        choice = sc.nextInt();
        if (choice < 1 || choice > 5) {
            System.out.println(choice + " isn't an option, please enter a number (1-5, inclusive");
        }
    }
    sc.nextLine();
} while (choice < 1 || choice > 5);
switch (choice) {
// ...