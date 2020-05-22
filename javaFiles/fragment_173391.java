ObjectMapper mapper = new ObjectMapper();
 List<Employee> empList = new ArrayList<>();

 while(rs.next())
 {
    Employee emp = new Employee();
    emp.setEmpId(Integer.parseInt(rs.getString("users.Employee_ID")));
    emp.setEmpName(rs.getString("users.Employee_Name"));
    empList.add(emp);
 }
 //Object to JSON in String
 String jsonInString = mapper.writeValueAsString(empList);