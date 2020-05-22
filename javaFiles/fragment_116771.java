Scanner scan = new Scanner(new File("/path/to/file.txt"));
scan.useDelimiter(Pattern.compile(";"));
while (scan.hasNext()) {
    String logicalLine = scan.next();
    // rest of your logic
}