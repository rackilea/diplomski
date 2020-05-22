stmnt = conn.createStatement();
conn.setAutoCommit(false);

stmnt.addBatch("insert statement for categories");
stmnt.addBatch("insert statement for skins");
stmnt.addBatch("insert statement for CategorySkins");
...

stmnt.executeBatch();
conn.commit();