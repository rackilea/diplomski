Date yourDate = ...
Connection conn = ...

String sql = "select * from CoefficienteRendimento where DataRendimento =  ?";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setDate(1, yourDate);
ResultSet rs = ps.executeQuery();
while (rs.next()) {
    ... // Handle your resultSet
}