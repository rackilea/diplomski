public static void deleteEmployee(int empId) {
    Iterator<Employee> iterator = list1.iterator();
    while (iterator.hasNext()) {
        Employee employee = iterator.next();
        if (employee.getEmpid() == empId) {
            System.out.println("The name of whose details deleted is  ::" + employee.getName()); // or whatever property in employee
            iterator.remove();
        }
    }

}