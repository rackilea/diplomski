while (s.hasNextLine()) {
    String line = s.nextLine();
    Scanner lineScanner = new Scanner(line);
    group = lineScanner.nextInt();
    death = lineScanner.nextInt();
    name = lineScanner.next();
    sex = lineScanner.next();
    age = lineScanner.nextInt();
    fare = lineScanner.nextDouble();
    lineScanner.close();
    System.out.println("Class = " + group); // Test that value is being assigned
    System.out.println("Death = " + death); // Test that value is being assigned
    System.out.println("Name = " + name); // Test that value is being assigned
    System.out.println("Gender = " + sex); // Test that value is being assigned
    System.out.println("Age = " + age); // Test that value is being assigned
    System.out.println("Fare = " + fare); // Test that value is being assigned
}