try {
  final String sql = "insert into colortable (string, color, cid) values (?,?,?)";
  final PreparedStatement ps = conn.prepareStatement(sql, new String[] {"ID"});
  ps.setString(1, "TEST1");
  ps.setString(2, "FFFFFF");
  ps.setInt(3, 1);
  ps.addBatch();
  ps.setString(1, "TEST2");
  ps.setString(2, "AAAAAA");
  ps.setInt(3, 1);
  ps.addBatch();
  ps.executeBatch();
  final ResultSet rst = ps.getGeneratedKeys();
  rst.getMetaData();
  if (rst != null){
    while (rst.next()) {
      final BigDecimal bigDecimal = rst.getBigDecimal(1);
      System.out.println(bigDecimal);
      Assert.notNull(bigDecimal);
    }
  }
  ps.close();
}catch (final SQLException e){
  System.out.println(e);
}finally {
}