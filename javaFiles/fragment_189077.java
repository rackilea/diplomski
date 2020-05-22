protected void doStart(String input) {
    Scanner scanner = new Scanner(input);
    scanner.next(); // Command
    String parameters[] = scanner.next().split(",");
    int x = Integer.parseInt(parameters[0]);
    int y = Integer.parseInt(parameters[1]);
    String dir = parameters[2];

    System.out.println(" > start @ " + x + "x" + y + " in " + dir + " direction");
}