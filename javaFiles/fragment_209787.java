protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    // Load the Driver class file
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    } catch (Exception e) {
       // *** Ideally, do something more useful with the exception or *don't* catch it
       System.err.println(e.getMessage());
       return;
    }

    try (
        // *** Note all auto-closeables are created here
        PrintWriter out = response.getWriter();
        // Make a connection to the ODBC datasource Movie Catalog
        // In this example we are opening a connection to the
        // database with every request.
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/movies","user1", "password");
        // Create the statement
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM USER1.TMovie");
        ) {

        out.println("<html>\n<body>\n<table border=\"1\" width=\"100%\">");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        out.println("<tr>");

        for(int i=1; i<=columnCount; i++) {
            out.println("<td><h3>" +rsmd.getColumnName(i) + "</td>");
        }
        out.println("</tr>");

        while ( rs.next() ) {
            out.println("<tr>");
            // get the id, which is an int
            out.println("<td>" + rs.getInt("id") + "</td>");
            // get the name, which is a String
            out.println("<td>" + rs.getString("title") + "</td>");
            // get the rating, which is a String
            out.println("<td>" + rs.getString("rating") + "</td>");
            // get the price, which is a Float
            out.println("<td>" + rs.getFloat("price") + "</td>");
            // get the Quantity, which is a Integer
            out.println("<td>" + rs.getInt("quantity") + "</td>");
            // get the Category, which is a Integer
            out.println("<td>" + rs.getString("category") + "</td>");
            out.println("</tr>");
        }// end while
        // *** Don't close auto-closeables like the result set
        out.println("</table>");
        /* *** This else was connected to an if (con != null), so the message doesn't really make sense
        else {
            out.println("Data Not Found");
        }
        */
    } catch (Exception e) {
        // *** Ideally, do something more useful here or don't catch the exception
        System.err.println(e.getMessage());
    }
    // *** No `finally` at all
}