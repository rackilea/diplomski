public static Connection get_conn (){
         Connection conn=null;

        try{
            conn =(Connection) DriverManager.getConnection(conn_str,username,pass);
       conn =(Connection) DriverManager.getConnection(conn_str,username,pass);
    }catch (SQLException e){
            System.out.println(e);
        }


       return conn;
    }