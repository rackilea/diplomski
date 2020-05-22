String polinom = "-x^3 - 6x^2 + 4x + 22";//here you pass data from user

Scanner scanner = new Scanner(polinom);
scanner.useDelimiter("(?=[+-])");

while (scanner.hasNext())
    System.out.println(scanner.next());

scanner.close();