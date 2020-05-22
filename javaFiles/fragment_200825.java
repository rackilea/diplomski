Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/testapp";
    String user = "root";
    String password = "root";
    connection = DriverManager.getConnection(url, user, password);


    Statement stmt = connection.createStatement();
    //You shouldn't need the semi-colon at the end
    String sql = "select * from site order by fname;";

    //missing piece
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()) {

        int id = rs.getInt("id");
        String name = rs.getString("name");
        System.out.println(id + "\t" + name);
    }