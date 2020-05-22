public void init() {
    try {
        _ds = (DataSource) InitialContext.lookup("java:/comp/env/_ds");
    } catch (Exception ex) {
    }
}

private javax.sql.DataSource _ds;

protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
{
    try {
        /*String driver = "com.mysql.jdbc.Driver";
        con = null;
        String username = "";
        String password = "";

        Class.forName("com.mysql.jdbc.Driver").newInstance();

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbName", "root", "password");*/
        Connection con=_ds.getConnection();
        Statement st = con.createStatement();
        ResultSet mar = st.executeQuery("SELECT * FROM table");


        Gson gson = new GsonBuilder().create();
        response.setContentType("application/json");  
        response.setCharacterEncoding("utf-8"); 
        con.close();
    } catch (SQLException e) {
        String message = e.getMessage();
    }