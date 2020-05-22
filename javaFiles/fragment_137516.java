for (int i=0; i<List1.size(); i++) {
    stmt.setString(1, List1[i]);
    stmt.setString(2, List2[i]);
    stmt.setString(3, List3[i]);
    stmt.addBatch();
}
stmt.executeBatch();