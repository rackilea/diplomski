...
Scanner scanner = new Scanner(readable);
scanner.useDelimiter("\u001E\r\n");
while (scanner.hasNext()) {
    String record = scanner.next();
    ...
}