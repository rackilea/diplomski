Scanner scanner = new Scanner(System.in);

System.out.println("Enter SQL statements");

scanner.useDelimiter("\n\n"); // an empty line
String sqlQuery = scanner.next();
scanner.reset(); // resets the delimiter