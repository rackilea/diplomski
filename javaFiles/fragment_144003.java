String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/citsp";
        String USER = "mydbuser";
        String PASS = "asdf";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            //JOptionPane.showMessageDialog(null, "There's an error connecting with the database. Please contact your administrator.");
        }
        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        //STEP 4: Execute a query
        System.out.println("Creating statement...");
        try {
            Statement stmt = conn.createStatement();
            String query = "";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                // Iterate through the result
            }
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }