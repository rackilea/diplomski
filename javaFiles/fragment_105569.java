boolean isUser=false;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:XXXX/Recommendation1", "root",
                "wXXXXX");
        Statement st = con.createStatement();           
        String SQL = "SELECT 1 from Table1 WHERE user_name ='"+ pname
                + "' ";
        ResultSet rs = st.executeQuery(SQL);
        isUser=rs.next();
        Statement st2 = con.createStatement();
        if (isUser) {   //check the user is exist or not

            int j = st2.executeUpdate("insert into Table2(movie_Id,movie_name,user_name,genre) values('"
                            + movieId
                            + "','"
                            + mname
                            + "','"
                            + pname
                            + "','" + genre + "') ");

     }else{

     int i = st2.executeUpdate("insert into Table1(movie_Id,movie_name,user_name,rating,genre) values('"
                        + movieId
                        + "','"
                        + mname
                        + "','"
                        + pname
                        + "','" + ratingr + "','" + genre + "') ");

       }