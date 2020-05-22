stmt = conn.createStatement();

  String sql = "CREATE TABLE password" +
               "(passwordId INTEGER not NULL, " +
               " password VARCHAR(20), " + 
               " PRIMARY KEY ( passwordId ))"; 

  stmt.executeUpdate(sql);