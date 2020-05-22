Scanner scanner = new Scanner(System.in);

System.out.print("CSV: ");
double csv = scanner.nextDouble();

System.out.print("CR: ");
double cr =  scanner.nextDouble();

if (csv < 0.0) {
    while (cr > 0.0) {
        System.out.println("CR cannot be positive since CSV is negative.");
        System.out.print("CR: ");
        cr = scanner.nextDouble();
    }
}