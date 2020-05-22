PreparedStatement stmt = connection.prepareStatement(
  "INSERT INTO xx (name, email) VALUES (?, ?)");

for (MyStructure s : list) {
  stmt.setString(1, s.name);
  stmt.setString(2, s.email);
  stmt.addBatch();
}

stmt.executeBatch();