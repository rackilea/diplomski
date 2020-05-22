try {
    PreparedStatement prepStmt = conn.prepareStatement(
    "UPDATE week SET " + s + " =? WHERE id>=? AND id<=?");
    prepStmt.setFloat(1, x);
    prepStmt.setInt(2, c);
    prepStmt.setInt(3, d);
    prepStmt.executeUpdate();
} catch(SQLException e) {
    System.err.println("Error during data update");
    e.printStackTrace();
}