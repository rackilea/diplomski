public class sqlaccess {
  void init(){
    try{
      Class.forName ("org.sqlite.JDBC");
      Connection conn = DriverManager.getConnection("jdbc:sqlite:TestUser.db");
       Statement stat = conn.createStatement();
      /* commented out the connecting/creating tables etc code */
    }
    catch(ClassNotFoundException ex){
       //Handle Exception
    }
  }
}