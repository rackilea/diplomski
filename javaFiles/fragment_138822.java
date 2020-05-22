public static void main(String[] args) {

  try{  
      Class.forName("net.sourceforge.jtds.jdbc.Driver");  
      Connection con1 = DriverManager.getConnection("jdbc:jtds:sybase://10.159.252.29:4100/fmdb","sa","Changeme_123");

      Class.forName(JDBC_DRIVER);
      Connection con2 = DriverManager.getConnection(DB_URL, USER, PASS);

      ///After getting both connections, write your code

      String a;
      String b;
      String c;

      Statement stmt= con1.createStatement();  
      ResultSet rs=stmt.executeQuery("select tbl_alm_log_2000000000.Csn, tbl_alm_log_2000000000.IsCleared, tbl_alm_log_2000000000.Id From fmdb.dbo.tbl_alm_log_2000000000 Where IsCleared = 0");  
      while(rs.next()) ///If your query result is single row, use if instead of while 
          {
          a = rs.getString(1);
          b = rs.getString(2);
          c = rs.getString(3);

          System.out.println(a+"  "+b+"  "+c);
          }

      String sql = "CREATE TABLE newtable " + "(id INTEGER not NULL, " + "first VARCHAR(255), " + "PRIMARY KEY ( id ))";
      stmt = con2.prepareStatement(sql);
      stmt.executeUpdate(sql);

      con1.close();
      con2.close();
      }catch(Exception e){ System.out.println(e);}  
   }    

}