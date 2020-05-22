connection.setAutoCommit(false);
try (PreparedStatement insert = connection.prepareStatement(qry)) {

    for (String s : sub) {//loop throw your array
        insert.setString(1, s);
        insert.addBatch();
    }
    insert.executeBatch();//executing the batch 
}
connection.commit();//commit statements to apply changes