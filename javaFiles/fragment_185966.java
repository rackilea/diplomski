public EmployeeViewRowImpl saveEmployee(EmployeeInfo EmployeeInfo) {
    // Получаем ViewObject
    EmployeeViewImpl employeeView = getEmployeeView1();
    // Готовим новую строку.
    EmployeeViewRowImpl employee = createEmployeeViewRowImpl(employeeView, employeeInfo);
    // Производим операцию вставки.
    employeeView.insertRow(employee);
    // Коммитим
    try {
        getDBTransaction().commit();
        return employee;
    } catch (JboException e) {
        getDBTransaction().rollback();
        return null;
    }
}

private EmployeeViewRowImpl createEmployeeViewRowImpl(EmployeeViewImpl employeeView, EmployeeInfo employeeInfo) {
        EmployeeViewRowImpl employee = (EmployeeViewRowImpl)EmployeeView.createRow();
        employee.setName(employeeInfo.getName());
        return employee;
}