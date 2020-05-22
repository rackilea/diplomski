public Object getValueAt(int row, int col) {
    EmployeeData employeeData = (EmployeeData)items.get(row);

    // however you are going to pick the right column object
    EmployeeTableColumn employeeColumn = EmployeeTableColumn.values()[col];

    return employeeColumn.getData(employeeData);
}