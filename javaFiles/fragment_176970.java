private boolean createConnection()
{
    try
    {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/contactDB","yohan","xyz");
    }
    catch(Exception e)
    {   
        System.out.println("Error getConnection");
        return false;
    }
 return true;   
}