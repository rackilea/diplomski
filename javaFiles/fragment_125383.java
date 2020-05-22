ResultSet resultSet = ps.executeQuery();
int rowcount = 0;
if (resultSet.last()) {
  rowcount = resultSet.getRow();
  resultSet.beforeFirst();
}