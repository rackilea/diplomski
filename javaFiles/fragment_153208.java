Connection con = DriverManager.getConnection("jdbc:derby:C:\\Users\\TheReaver\\MyDB;create=true;user=thereaver;password=12345");
        PreparedStatement st = con.prepareStatement("SELECT ID, NAME FROM APP.TABLE1");
        try
        {
            ResultSet res = st.executeQuery();
        }
        catch(SQLException e) {
            //if table not found, then create all tables
            st.executeQuery("CREATE TABLE TABLE1(ID int, NAME varchar(20)))");
            //execute all statements that create your database
            //or execute an sql file that stores all your queries
        }