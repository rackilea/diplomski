Scanner scanner = new Scanner(s);
scanner.useDelimiter("::?");
int id = scanner.nextInt();
String className = scanner.next();
int orderOfExecution = scanner.nextInt();
String methodNameOrNew = scanner.next();
scanner.useDelimiter("$").skip("::");
String[] arguments = scanner.next().split("::");