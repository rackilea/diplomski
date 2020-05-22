EmployeeBuidler employeeBuilder = new EmployeeBuilder(firstName, lastName);

Sex sex = ...; 
String salutation = ...;

employeeBuilder.setSex(sex);
employeeBuilder.setSalutation(salutation);

Employee employee = employeeBuilder.build();