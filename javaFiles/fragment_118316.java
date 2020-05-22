String source = "city1, country; city2, country; 145 km";
Scanner scanner = new Scanner(source);
scanner.useDelimiter(";");

while (scanner.hasNext()) {
    // trim() removes leading and trailing whitespace
    String line = scanner.next().trim();
    // split the line on either ',' or a space
    String[] split = line.split(",|\\s");
    // print the first word
    System.out.println(split[0]);
}