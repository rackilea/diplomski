String test = "123(3 4)56(7)";

Scanner scanner = new Scanner(test);
scanner.useDelimiter("(?:\\s+)|(?<=[()])|(?=[()])");
while(scanner.hasNext()) {
    System.out.println(scanner.next());
}