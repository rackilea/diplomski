<%   //dbconnection
          try {
                   Class.forName("com.mysql.jdbc.Driver");
                 java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
                  Statement statement = conn.createStatement() ;
       resultSet=statement.executeQuery("select * from tablename") ; 
                %>
       <% while(resultSet.next()){ %> 

   Image - <img src="ImageProcess?id=<%=resultSet.getString("id")%>" width="20%"/>

    <% 
    }
    }catch(Exception e){}

    %>