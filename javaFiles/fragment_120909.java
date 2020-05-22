char c;
while ((c = input.nextLine().toUpperCase().charAt(0)) != 'N') {
    System.out.println("Enter your First Name");
    firstName = input.nextLine();
    System.out.println("Enter your Last Name");
    lastName = input.nextLine();
    System.out.println("Enter your ID Number");
    id = input.nextInt();
    System.out.println("Enter your Hourly Wage");
    hourlyWage = input.nextDouble();

    EmployeeData em2 = new EmployeeData("firstName", "lastName", id, hourlyWage);

    em2.setFirstName(firstName);
    em2.setLastName(lastName);
    em2.setId(id);
    em2.setHourlyWage(hourlyWage);

    // String z = em2.toString();
    System.out.println(em2);
}
System.out.println("You have finished.");