private void writeEmployeeInfo() {

    ListIterator<Employee> employeeListIterator = Employee
            .getEmployeeList().listIterator();

    int rowIndex = 1;

    while (employeeListIterator.hasNext()) {

        Employee employee = employeeListIterator.next();

        Row row = sheet.createRow(rowIndex++);

        row.createCell(0).setCellValue(employee.getfName());
        row.createCell(1).setCellValue(employee.getSName());
        row.createCell(2).setCellValue(employee.getAddress);
    }
}