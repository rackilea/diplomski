final ArgumentCaptor<Employee> employeeCaptor = ArgumentCaptor.forClass(Employee.class);

Mockito.doAnswer(invocation -> {
    Employee employee = employeeCaptor.getValue();
    if(employee.getId() > 1 && employee.getId() < 100)
      return object1;
    else if(employee.getId() > 101 && employee.getId() < 200)
      return object2;
    else someOtherObject;
}).when(someClass).process(employeeCaptor.capture());