List<Employee> employees = new ArrayList<>();

while (!emp.name.equals("STOP")) {
 Employee emp = new Employee();
 // read all the data from input

 employees.add(emp);
}

for(Employee emp : employees) {
 System.out.println(emp.name);
}