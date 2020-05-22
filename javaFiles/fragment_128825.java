Scanner scanner = new Scanner(System.in);
System.out.println("Please enter values to sum (type quit to stop)");
while (scanner.hasNextLine()) {
    String str = scanner.nextLine();
    str = (str != null) ? str.trim() : "";
    if (str.equalsIgnoreCase("quit")) {
        break; // <-- end the loop.
    } else if (str.length() == 0) {
        continue;
    }
    int sum = 0; // <-- start at 0.
    int count = 0;
    Scanner scan2 = new Scanner(str);
    while (scan2.hasNextInt()) {
        count++;
        sum += scan2.nextInt();
    }
    System.out.printf("The sum of your %d values is %d.%n", count, sum);
}