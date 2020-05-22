public class DDLDMLStatementsinJDBC
{
    public static final String URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=Dummy;sendStringParametersAsUnicode=false";
    public static final String DBUSER = "sa";
    public static final String DBPASS = "Welcome12!";

    public static void main(String[] args) throws Exception, SQLException
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);

            System.out.println("Connection Established ln");
            Statement query = conn.createStatement();


            String SQL = "SET NOCOUNT OFF;";
            String SQL_Create = "CREATE TABLE SELCREATEDB" + "(PersonID int, LastName varchar(255), FirstName varchar(255), Address varchar(255), City varchar(255));";

            String SQL1 = "INSERT INTO dbo.SELCREATEDB VALUES " + "(1000, 'Davis', 'John', '3444 Mulberry Lane', 'Oakland CA')";
            String SQL2 = "INSERT INTO dbo.SELCREATEDB VALUES " + "(1001, 'Robinson', 'Larry', '5633 Skyline Drive', 'Annandale VA')";
            String SQL3 = "INSERT INTO dbo.SELCREATEDB VALUES " + "(1002, 'Arafat', 'Yasser', '5633 Quidbury Lane', 'Hezburg Israel')";
            String SQL4 = "INSERT INTO dbo.SELCREATEDB VALUES " + "(1003, 'Castro', 'Fidel', '5234 Honey Tree Avenue', 'Port Lunciana Cuba')";
            String SQL5 = "INSERT INTO dbo.SELCREATEDB VALUES " + "(1004, 'Carter', 'Jimmy', '9234 Mackel Court', 'Lynchburg VA')";

            query.addBatch(SQL);
            query.addBatch(SQL_Create);

            query.addBatch(SQL1);
            query.addBatch(SQL2);
            query.addBatch(SQL3);
            query.addBatch(SQL4);
            query.addBatch(SQL5);

            query.executeBatch();

            conn.close();
        }
        catch (SQLServerException sqe)
        {
            System.out.println("A result set was generated for update.");
            sqe.printStackTrace();
        }
        catch (java.sql.BatchUpdateException bae)
        {
            System.out.println("Executed Queries! Terminating Connection...");
            bae.printStackTrace();
        }
    }
}