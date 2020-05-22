CallableStatement stmt = connection.prepareCall("{call name (2)}");
stmt.setInt(1, cod);

stmt.execute();

ResultSet rs = (ResultSet)stmt.getObject(index);

//Loop results
while (rs.next()) {
  ret = new myReturn(resSet.getInt("someValue")
}