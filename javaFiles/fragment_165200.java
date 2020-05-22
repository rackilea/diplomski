private static final String CALL_PROCEDURE = "{ call my_procedure(?, ?) }";
...
private void callMyProcedure(Connection c) throws SQLException {
  CallableStatement cs = null;
  try {
    cs = c.prepareCall(CALL_PROCEDURE);
    cs.setString(1, "firstValue");
    cs.setString(2, "secondValue");
    cs.execute();
  } finally {
    if (cs != null) {
      cs.close();
    }
  }
}