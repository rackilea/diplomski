class AplPojo {
    private String text;
    private String altname;
    private String altname;
    private String icd10;
    private String alphaid;

     //getter and setters
  }
  public static String getDBEntries(String tablename) {

    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    ArrayList<AplPojo> aplPojos = new ArrayList<AplPojo>();
    int index = 0;
    try {
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/users");
        conn = ds.getConnection();
        st = conn.createStatement();
        rs = st.executeQuery("SELECT * FROM " + tablename);
        while (rs.next()) {
            AplPojo  aplPojo= new AplPojo();
            aplPojo.setText(rs.getString("text"));
            aplPojo.setAltname(rs.getString("altname"));
            aplPojo.setAltname2(rs.getString("altname2")); 
            aplPojo.setIcd10(rs.getString("icd10")); 
            aplPojo.setAlphaid(rs.getString("alphaid"));
            index++;
            aplPojos.add(aplPojo);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (st != null) st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
     // create a new Gson instance
     Gson gson = new Gson();
     // convert your list to jsonArray
     String aplPojosList = gson.toJson(aplPojos);
     return aplPojos;
}