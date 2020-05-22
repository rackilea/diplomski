PreparedStatement stmt = connection.prepareStatement(
    "UPDATE table SET field=? WHERE id=?;\n" + 
    "INSERT INTO table (id, field) \n" +
    "       SELECT ?, ? \n" +
    "       WHERE NOT EXISTS (SELECT 1 FROM table WHERE id=?)";

stmt.setString(1, "C");
stmt.setInt(2, 3);
stmt.setInt(3, 3);
stmt.setString(4, "C");
stmt.setInt(5, 3);
stmt.executeUpdate();

connection.commit();