public ArrayList<Integer> getAssignedProxies() throws Exception {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    ArrayList<Integer> list = new ArrayList<Integer>();

    try {
      Class.forName("org.postgresql.Driver");
      conn = DriverManager.getConnection(url, props);
      pst = conn
          .prepareStatement("select distinct(proxy_id) from account where proxy_id IS NOT null AND enabled = true");

      rs = pst.executeQuery();

      while (rs.next()) {
        list.add(rs.getInt("proxy_id"));
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (pst != null) {
        pst.close();
      }
      if (rs != null) {
        rs.close();
      }
      if (conn != null) {
        conn.close();
      }
    }

    return list;
  }

  public ArrayList<Integer> getAllProxies() throws Exception {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    ArrayList<Integer> list = new ArrayList<Integer>();

    try {
      Class.forName("org.postgresql.Driver");
      conn = DriverManager.getConnection(url, props);
      pst = conn.prepareStatement("select distinct(id) from proxy");

      rs = pst.executeQuery();

      while (rs.next()) {
        list.add(rs.getInt("id"));
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (pst != null) {
        pst.close();
      }
      if (rs != null) {
        rs.close();
      }
      if (conn != null) {
        conn.close();
      }
    }

    return list;
  }

  public Integer getLeastUsedProxy() throws Exception {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    Integer leastUsedProxy = null;

    try {
      Class.forName("org.postgresql.Driver");
      conn = DriverManager.getConnection(url, props);
      pst = conn
          .prepareStatement("SELECT proxy_id, count(proxy_id) FROM account GROUP by proxy_id ORDER BY count LIMIT 1");

      rs = pst.executeQuery();

      while (rs.next()) {
        leastUsedProxy = rs.getInt("proxy_id");
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (pst != null) {
        pst.close();
      }
      if (rs != null) {
        rs.close();
      }
      if (conn != null) {
        conn.close();
      }
    }

    return leastUsedProxy;
  }