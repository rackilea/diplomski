Connection connection = DriverManager.getConnection(...);
for(Employee e:selectedEmployees)
{
   System.out.println("Employee id: "+e.id+" name: " + e.name+ " remarks: " + e.remarks);
   String sql = "INSERT INTO employees (id,name,remarks) VALUES(?,?,?);";
   PreparedStatement statement = connection.prepareStatement(sql);
   statement.setInt(1, e.id);
   statement.setString(2, e.name);
   statement.setString(3, e.remarks);
   statement.executeUpdate();
}