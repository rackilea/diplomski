PreparedStatement stmt = con.prepareStatement(
    "INSERT INTO employees('salary', 'name') VALUES (?, ?)");

stmt.setInt(1, 2000);
stmt.setString(2, "Kelly Kaufmann");
stmt.addBatch();

stmt.setInt(1, 3000);
stmt.setString(2, "Bill Barnes");
stmt.addBatch();

// submit the batch for execution
stmt.executeBatch();