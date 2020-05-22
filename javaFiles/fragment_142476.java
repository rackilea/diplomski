// launch the application
public static void checkLogin(String username, String password)
        throws SQLException {
    System.out.print("dfdF");

    Connection connection = null; // manages connection
    PreparedStatement pt = null; // manages prepared statement

    // connect to database usernames and query database
    try {

        // establish connection to database
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection(DATABASE_URL, "root", "root");

        // query database
        pt = con.prepareStatement("select userName,password from person where userName=?");

        // process query results
        pt.setString(1, username);
        ResultSet rs = pt.executeQuery();
        String orgUname = "", orPass = "";
        while (rs.next()) {
            orgUname = rs.getString("userName");
            orPass = rs.getString("password");
        } //end while
        if (orPass.equals(password)) {
            //do something
            rs.close();
        } else {
            //do something
        }
    }//end try
    catch (Exception e) {
    } //end catch  
} //end main