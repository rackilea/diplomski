String command = "A5 B10 11C 20D";
for (String pair : command.split("\\s+")) {
    int x = pair.replaceAll("\\d", "").charAt(0) - '@';
    int y = Integer.parseInt(pair.replaceAll("\\D", ""));
    System.out.format("X = %d, Y = %d\n", x, y);
}