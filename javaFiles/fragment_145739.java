Employee[] employees = new Employee[4];
employees[0] = new Employee("Jane", 26000);
employees[1] = new Employee("Jack");
employees[2] = new Employee("Lucy", 52000);
employees[3] = new Employee("Lenny");

Scanner sc = new Scanner(System.in);

for (Employee employee : employees) {
    if(employee.isPartTimeEmployee()) {
        System.out.println("Please enter working hours by " + employee.getName() + ": ");
        int numHours = sc.nextInt();
        employee.setWorkingHours(numHours);
    }
}