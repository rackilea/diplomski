int i = 0;
Scanner scanner = new Scanner(System.in);
while(i < 10) {
    System.out.print("Enter a value: ");
    int value = scanner.nextInt();
    scanner.nextLine();
    if (value > 0) {
        System.out.println("\nPositive value: " + value);
        i++;
    }
}