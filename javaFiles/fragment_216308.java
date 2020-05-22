doInJPA(entityManager -> {
    Employee employee = new Employee();
    employee.setId(new EmployeeId(1L, 100L));
    employee.setName("Vlad Mihalcea");
    entityManager.persist(employee);
});

doInJPA(entityManager -> {
    Employee employee = entityManager.find(Employee.class, new EmployeeId(1L, 100L));
    EmployeeDetails employeeDetails = new EmployeeDetails();
    employeeDetails.setEmployee(employee);
    employeeDetails.setDetails("High-Performance Java Persistence");
    entityManager.persist(employeeDetails);
});

doInJPA(entityManager -> {
    EmployeeDetails employeeDetails = entityManager.find(EmployeeDetails.class, new EmployeeId(1L, 100L));
    assertNotNull(employeeDetails);
});
doInJPA(entityManager -> {
    Phone phone = entityManager.find(Phone.class, "012-345-6789");
    assertNotNull(phone);
    assertEquals(new EmployeeId(1L, 100L), phone.getEmployee().getId());
});