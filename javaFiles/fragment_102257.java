private Employee getEmployeeData() {
    Employee employee = new Employee();
    Shift shift = new Shift();
    employee.addShift(shift);
    shift.setEmployee(employee); // Adding this line fixes the issue.
    return employee;
}