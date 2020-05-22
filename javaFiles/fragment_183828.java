String URL = "jdbc:mysql://localhost/test";
    String username="root";
    String pwd = "";
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection(URL,username,pwd);
    Statement stat = con.createStatement();
    stat.execute("SELECT * FROM getjson");

    ResultSet resultSet = stat.getResultSet();

    while(resultSet.next()){
        String data = resultSet.getString("json");
        System.out.println("JSON DATA IS " + data);
    }