try {
      con = DriverManager.getConnection(url, user, password);
      st = con.createStatement();
      rs = st.executeQuery("show fields from tableA");
      while (rs.next()) {
           System.out.println(rs.getString(1)+": "+rs.getString(2));
} catch (SQLException ex) {
     Logger lgr = Logger.getLogger(myTest.class.getName());
     lgr.log(Level.SEVERE, ex.getMessage(), ex);
}