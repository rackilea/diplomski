try {
ps.executeBatch();
connection.commit();
/*Some more code*/

} catch (BatchUpdateException e) {

connection.rollback();
/*Some more code*/

continue;
}