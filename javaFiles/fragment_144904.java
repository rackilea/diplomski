public void GenerateTXT() { 
   Connection conn = null;
   Statement stmt = null;
   try{ 
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();

      File file = new File("/path/to/file/filename.txt");

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

      String sql = "SELECT id, name, amount FROM Employee";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
         int id  = rs.getInt("id");
         int age = rs.getString("name");
         String first = rs.getInt("amount");
         bw.append(id+"|"+age+"|"+first+"\n");
          } 
      rs.close();
      bw.close();
   }catch(SQLException se){ 
      se.printStackTrace(); 
   }catch(Exception e){
      e.printStackTrace();
   }finally{ 
      try{ 
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){ 
      } 
      try{ 
         if(conn!=null)
            conn.close();
      }catch(SQLException se){ 
         se.printStackTrace(); 
      } 
   } 
} 
}