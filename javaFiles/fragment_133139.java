System.out.println("Select operation (1 - 5): ");
while (!sc.hasNextInt()) {
    sc.nextLine();
    System.out.println("Please entire a number [1 - 5]:");
}
choice = sc.nextInt();
sc.nextLine();
switch (choice) {
// ...