String sql="select one,two,three,four from table where id=1";
    Connection con = DriverManager.getConnection("");//get connection here
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    String[] result = new String[4];
    while(rs.next()){
        result[0] = rs.getString(1);
        result[1] = rs.getString(2);
        result[2] = rs.getString(3);
        result[3] = rs.getString(4);
    }