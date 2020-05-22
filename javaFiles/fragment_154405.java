while (resultSet.next()) {
    //instantiate a new Employee object
    Employee employee = new Employee();

    //set instance variables from the row from the database
    employee.setId(resultSet.getString("emp_id"));
    // ... etc.

    //each new Employee object added to the Search object
    search.addFoundEmployee(employee);    
}

// employeeList is never null so we don't check for it, just its size
if( search.getEmployeeList().size() > 0 ){
     search.setEmployeeFound(true);
}