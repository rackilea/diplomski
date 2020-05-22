Connection conn = null;
    Statement stmt = null;
    ResultSet query_set = null;
    try {
        String query = "insert into users values(1,'name')";
        Class.forName ("oracleDriver"); //Oracle driver as our database is Oracle.
        conn = DriverManager.getConnection("oracleDbUrl", "dbUsername", "dbchecksum"); //login credentials to the database
        stmt = conn.createStatement();
        if(query.startsWith("select"))
            query_set = stmt.executeQuery(query);
        else
            System.out.println("Only select query allowed");
    } catch(Exception e) {
        e.printStackTrace();
    }