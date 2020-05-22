Connection conn = ...
conn.setAutoCommit(false);
try {
   doAction1(connection);
   doAction2(connection);
   doAction3(connection);
   doAction4(connection);

   connection.commit();
} catch (Exception ex) {
   connection.rollback();
}