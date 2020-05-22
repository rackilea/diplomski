//initiate connection, statement etc
String generatedColumns[] = {"ID"};
pStatement = connection.prepareStatement(SQL, generatedColumns);
pStatement.setString(1,'blabla');

pStatement.executeUpdate();
ResultSet rs = pStatement.getGeneratedKeys();

while (rs.next()){
  //debugging here to see what rs has
}