conn.setAutoCommit(false);
CallableStatement stmt = conn.prepareCall(sql);
while(true) {
    stmt.setInt(1, value);
    stmt.execute();
}
conn.commit();
conn.setAutoCommit(true);