for (Employee employee: employeeList){  
    List<Employee> departmentList = f1soft.get(employee.getDepartment());
    if (departmentList == null) {
        departmentList = new ArrayList<>();
        f1soft.put(emp.getDepartment(), departmentList);
    }
    departmentList.add(employee);
}