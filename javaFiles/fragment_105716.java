cpfCalculator c = new cpfCalculator("El Salvador", 10000, 70000, 2000, "P", 0.451651);
System.out.println("INPUT VALUES");
System.out.println("*************");
System.out.println("Person's Name:" + c.getName() + "_ Savings ($):" + c.getSavings() + "_ Desired Amount ($):" + c.getDesiredAmt());
System.out.println("Salary ($):" + c.getSalary() + "_ Citizen or PR:" + c.getCitizen());
System.out.println("");

Age a = new Age( c.getSalary(), c.getSavings()); // ADD this line

System.out.println("OUTPUT VALUES");
System.out.println("*************");
System.out.println(age.getAge());