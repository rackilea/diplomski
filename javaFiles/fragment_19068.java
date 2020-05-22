Class.forName(sun.jdbc.odbc.JdbcOdbcDriver) ;

       // setup the properties 
       java.util.Properties prop = new java.util.Properties();
       prop.put("charSet", "Big5");
       prop.put("user", username);
       prop.put("password", password);

       // Connect to the database
       con = DriverManager.getConnection(url, prop);