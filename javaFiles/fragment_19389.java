WebSphereNativeJdbcExtractor nje = new WebSphereNativeJdbcExtractor();
Connection connect = dbUtil.getDataSource().getConnection();
Connection conn =  nje.getNativeConnection(connect);

try {
  ...
} catch (Exception e) {
    throw e;
} finally {
    connect.close();
}