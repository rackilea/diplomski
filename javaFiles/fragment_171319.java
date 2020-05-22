public Connection connectToDatabase(){
          String url = "jdbc:postgresql://url";
          return DriverManager.getConnection(url);    
     }

     Connection conn = connectToDatabase();
     PreparedStatement pstInsert = conn.prepareStatement(cInsert);
     pstInsert.setTimestamp(1, fromTS1);
     pstInsert.setString(2, nextLine[1]);
     pstInsert.execute();
     pstInsert.close();
     conn.close();