Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
      conn = getConnection();
      pstmt = conn.prepareStatement("SELECT tbl_a.* FROM tbl_a WHERE ID1=? AND Id2=?");
      pstmt.setNull(1, java.sql.Types.INTEGER);
      pstmt.setNull(2, java.sql.Types.INTEGER); 
      rs = pstmt.executeQuery();
      while (rs.next()) {
          //capture data from the returned rows
      }
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      pstmt.close();
      rs.close();
      conn.close();
    }