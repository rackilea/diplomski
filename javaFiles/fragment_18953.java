Scanner scanner = new Scanner(y);
if (scanner.hasNextLine()) // Skips first line
    scanner.nextLine();
while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    ...
}