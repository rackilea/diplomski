connection.setAutoCommit(false);
statement.addBatch("UPDATE FIRST_TABLE SET FIRST_FIELD = 1");
statement.addBatch("UPDATE SECOND_TABLE SET SECOND_FIELD = 2");
statement.addBatch("UPDATE THIRD_TABLE SET THIRD_FIELD = 3");
int [] counts = statement.executeBatch();
connection.commit();