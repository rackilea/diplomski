@DataSourceDefinition(
        className = "com.mysql.jdbc.Driver",
        name = "java:global/jdbc/MyDS",
        serverName="localhost",
        portNumber=3306,
        user = "root",
        password = "admin",
        databaseName = "test"
)
@Stateless
public class DBConfig {
    public void test() { //there should be atleast one method, so this dummy
    }
}