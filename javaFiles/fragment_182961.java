Connection connect = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1/"+databaseName+"?user="+username+"&password="+password);          
            PreparedStatement prep = connect.prepareStatement("INSERT INTO t_languagetable (id,languagecode,displayname) VALUES (?,?,?)");
            prep.setInt(1,7);
            prep.setString(2,"AA");
            prep.setNString(3,"Русский");

            prep.execute();
            System.out.println("Data Inserted.");
            connect.close();
        } catch (Exception e) {
            System.out.println("problem during the connection with the database!"+e);
        }