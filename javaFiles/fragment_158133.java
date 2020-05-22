import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.h2.tools.Server;
import org.junit.Before;
import org.junit.Test;

public class H2ServerDownTest
{

    private Server server;

    @Before
    public void startServer() throws SQLException
    {
//        TCP server only.
        server = Server.createTcpServer("-tcp -webPort 8008 -tcpPort 9008 -properties null".split(" "));
        System.out.println("Start Server AT: " + server.getURL());
    }

    @Test(expected = SQLException.class)
    public void test() throws SQLException
    {
        server.start();
        Connection c = getConnection();
        Statement stmt = c.createStatement();
        stmt.execute("create table test(id int primary key, val varchar(100))");
        for (int i = 0; i < 1000; i++)
        {
            if (i == 500)
            {
                server.stop();
            }
            stmt.execute("insert into test values(" + i + ", 'values')");
        }
    }

    public Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:h2:"+server.getURL()+"/mem:db", "sa", "");
    }

    @Test
    public void shutdownServer()
    {
        server.shutdown();
    }
}