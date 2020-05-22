public void put(String name, InputStream data) throws SQLException, IOException {
    Connection con = null;
    PreparedStatement set = null;
    try {
      con = m_dataSource.getConnection();
      set.prepareStatement(SET_SQL);
      set.setString(1, name);
      set.setBinaryStream(2, data);
      set.executeUpdate();
    } finally {
      if (set != null) {
        set.close();
      }
      if (con != null) {
        con.close();
      }
    }
  }