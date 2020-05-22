String s="";  
s=date.getText();//selected data from date picker
s.replace(".","_");
try
{
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    ResultSet acrs;
    String op = "jdbc:odbc:vasu";
    Connection cnn = DriverManager.getConnection(op,"username", "password");
    Statement mystmt = cnn.createStatement();

    int successOrFailure = mystmt.executeUpdate("ALTER TABLE attendance ADD '"+s+"' VARCHAR(50)");
    //executeUpdate return 1 if the query work properly otherwise it will return 0

}catch(Exception e)
{
    System.out.println("Exception:"+e);
    e.printStackTrace();
}