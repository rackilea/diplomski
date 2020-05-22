while (s.hasNextLine()) {
    String line = s.nextLine();
    Scanner lineScanner = new Scanner(line);

    if (lineScanner.hasNextInt()) {
        group = lineScanner.nextInt();
    }
    if (lineScanner.hasNextInt()) {
        death = lineScanner.nextInt();
    }
    if (lineScanner.hasNext()) {
        name = lineScanner.next();
    }
    if (lineScanner.hasNext()) {
        sex = lineScanner.next();
    }
    if (lineScanner.hasNextInt()) {
        age = lineScanner.nextInt();
    }
    if (lineScanner.hasNextDouble()) {
        fare = lineScanner.nextDouble();
    }
    lineScanner.close();

    System.out.println("Class = " + group); // Test that value is being assigned
    System.out.println("Death = " + death); // Test that value is being assigned
    System.out.println("Name = " + name); // Test that value is being assigned
    System.out.println("Gender = " + sex); // Test that value is being assigned
    System.out.println("Age = " + age); // Test that value is being assigned
    System.out.println("Fare = " + fare); // Test that value is being assigned
}