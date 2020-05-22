Employee employee = new Employee();
    employee.setId(rs.getInt("id")); //or (1)
    employee.setName(rs.getString("name"));//or (2)
    employee.setSalary(rs.getInt("salary"));//or (3)
    employee.setDesignation(rs.getString("designation"));//or (4)
    return employee;