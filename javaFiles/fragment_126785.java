Scanner scanner = new Scanner(System.in);
double reapHeight;
boolean valid = false;
do {
    try {
        reapHeight = scanner.nextDouble();
        scanner.nextLine();
        valid = true;
    } catch (Exception e) {
        System.out.println("Error : Invalid Input");
        System.out.print("Please try again : ");
        scanner.nextLine();
    }
} while (!valid);