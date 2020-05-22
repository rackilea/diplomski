String sql = "insert into employee (name, city, phone) values (?, ?, ?)";
Connection connection = new getConnection();
PreparedStatement ps = connection.prepareStatement(sql);

for (Employee employee: employees) {

    ps.setString(1, employee.getName());
    ps.setString(2, employee.getCity());
    ps.setString(3, employee.getPhone());
    ps.addBatch();
}
ps.executeBatch();