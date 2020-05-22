Object object = array[i];
if (object instanceof Employee) {
    Employee employee = (Employee) object;
    employee.getSalary();
}
else {
    System.err.println("Object is not an Employee: we can not call getSalary()!");
}