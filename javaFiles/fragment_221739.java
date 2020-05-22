public Employee getEmployeeById(long empId){
    for(Employee e : employeeList) {
        if(e.getId() == empId){
            return e;
        }
    }
    return null;
}