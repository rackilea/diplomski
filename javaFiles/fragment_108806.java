try {
  ...
  Clob clob = new SerialClob(stringData.toCharArray());
  ...
}
catch (SQLException e) {
  // do handle better than this, however
  e.printStackTrace();
}