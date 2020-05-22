List<Employee> employeeDetails = new ArrayList<Employee>;
try{

List<Employees> allEmployees = EmployeeLocalServiceUtil.getAllEmployees();

        for(Employee emp: allEmployees {
           if(emp.getEmpStatus.equals("Pending")  {
employeeDetails.add(emp);
       }
}return employeeDetails;