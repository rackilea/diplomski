public class gaConnection 
{
String url ="";
Connection conn=null;
Statement statement=null;
ResultSet resultSet=null;
    public void setConnection(String DBName,String UserName,String Password)
    {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            url ="jdbc:jtds:sqlserver://10.0.2.2:1433;instanceName=14GRAFICALI\\MSSQLSERVER2008;DatabaseName="+DBName+";integratedSecurity=true;user="+UserName+";password="+Password;
            conn =DriverManager.getConnection(url);
            } catch (Exception e) {
            e.printStackTrace();
            }
    }
    public String showResult()
    {
        String strResult="";
        try
        {
            statement=conn.createStatement();
            resultSet=statement.executeQuery("select * from UserMaster");
            while(resultSet.next()){
               strResult = strResult + " Name : "+resultSet.getString(1)+"  SirName : "+resultSet.getString(2) + "\n";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return strResult;
    }

}