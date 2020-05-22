while (rs.next()) {
  id = rs.getInt("id");
  name = rs.getString("name");
  Employee employee = new Employee(id, name, surname);
  EmployeeListViaSurname.add(employee);
}