String sql = "insert  into " + tempTableName + " values (?)";
PreparedStatement stmt = connection.prepareStatement(sql);
for (String query : readQueries) {
  stmt.setCharacterStream(1, new StringReader(query), query.lenght());
  stmt.addBatch();
}
stmt.exececuteBatch();