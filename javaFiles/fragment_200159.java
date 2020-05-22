while (resultSet.next())
{

  int id= rs.getInt("id");
  String name= rs.getString("name");
  int firstTableSalary = rs.getInt("salary");

  rs.next();
  int secondTableSalary = rs.getInt("salary");

  console.log(String.format("The first table salary is %d, while the second table salary is %d, name=%s, id=%d", firstTableSalary, secondTableSalary, name, id);

}