public class Connect
{
private static Connection sharedConnection;
public static Connection createOrAccessConnection(String user,String pass, boolean forceNew){ 
Connection connect = sharedConnection;
try
  {

      Class.forName("com.mysql.jdbc.Driver");
      if(forceNew || connect == null)
         { 
              connect = DriverManager.getConnection(
                "jdbc:mysql://localhost/MYDATABASE?user="+username+"&password="+password);
              if(sharedConnection == null ) 
                { 
                sharedConnection = connect; 
                }  
         }
return connect;
  }catch(Exception e){
      return null;
}
}



class Main
   {
   public void transactionMethod()
   {
       //Some code here.
       //This is what you need to add.
       Connection con = Connect.createConnection(user,pass,false);
       Sysout(con);
       AnotherClass ac = new AnotherClass();
       ac.operation1(con, false);
       ac.operation1(null,true);  
   }



class AnotherClass
       {
       public void operation1(Connection con, boolean createNew) 
            {
            if(createNew || con==null)
               {
               con = Connect.createConnection(user,pass,false);
               }
            //Some code here
            if(createNew)
               {
               //Close connection here. 
               }      
            }
       } 

       }