Scanner scanner = new Scanner(System.in).useDelimiter(";\\h*\\R");
for (;;) {
    System.out.print(">");
    if (! scanner.hasNext())
        break;
    String stmt = scanner.next();
    stmt = stmt.replaceAll("(?mU:^\\s+\\R)|(?U:\\s+$)", ""); // remove blank lines and trailing spaces
    if (stmt.equals("exit"))
        break;
    System.out.println("Received command: " + stmt);
}
System.out.println("Done!");