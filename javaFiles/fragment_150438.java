List<Employee> employees = new ArrayList<Employee>();
...
Employee emp = new Employee();
for (int i = 0; i < sheet.getColumns(); i++) 
{ 
    Cell cell = sheet.getCell(i, j);
    switch (i) {
    // column 0 = ID
    case 0:
        emp.setId(cell.getContents());
        break;
    // column 1 = Name
    case 1:
        emp.setName(cell.getContents());
        break;
    // column 2 = Email
    case 2:
        //... etc
        break;
    }

}
employees.add(emp);