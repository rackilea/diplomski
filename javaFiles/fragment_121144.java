PreparedStatement ps = null;

ps = conn.prepareStatement("INSERT INTO tbl_Customer VALUES(?,?,?,?)");
while () { 
    ...
    ps.addBatch();
}
result = ps.executeBatch();