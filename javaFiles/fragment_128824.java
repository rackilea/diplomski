Scanner scanner = new Scanner(System.in);
// System.out.print("How many values do you want to parse?: ");
// int numValues = scanner.nextInt();
System.out.println("Please enter values to sum (type quit to stop)");
int sum = 0; // <-- start at 0.
int count = 0;
while (scanner.hasNext()) {
    if (scanner.hasNextInt()) {
        count++;
        sum += scanner.nextInt();
    } else {
        String str = scanner.next();
        if (str.equalsIgnoreCase("quit")) {
            break; // <-- end the loop.
        }
        System.out.printf("The value '%s' is not an int (quit to stop).%n", str);
    }
}
System.out.printf("The sum of your %d values is %d.%n", count, sum);
// scanner.close(); // <-- Really Bad Idea