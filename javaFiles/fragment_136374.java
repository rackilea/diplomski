import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class SimpleTextFileDBConnectionConfig {

    //  MYSQL_DRIVER("com.mysql.jdbc.Driver", "jdbc:mysql://%host%:%port%/%dbname%?verifyServerCertificate=%vsc%&useSSL=%usessl%&requireSSL=%requiressl%"), //

    static public Connection getSimpleDBConnectionByTextFileConfig(final String pFileName) throws ClassNotFoundException, IOException, SQLException {
        final HashMap<String, String> settings = new HashMap<>();
        { // load settings from file; could also drop this in separate method
            final List<String> lines = Files.readAllLines(Paths.get(pFileName));
            for (final String line : lines) {
                if (line == null || line.length() < 1 || line.startsWith("#")) continue; // ignore certain lines
                final String[] setting = line.trim().split(" ", 2);
                final String key = setting[0].trim();
                final String value = setting[1].trim();
                settings.put(key, value);
            }
        }

        // load driver
        final String driverName = settings.get("drivername"); // can be "com.mysql.jdbc.Driver" for default java mysql driver
        Class.forName(driverName);

        // set timeout
        final String timeout = settings.get("timeout");
        if (timeout != null && timeout.length() > 0) DriverManager.setLoginTimeout(Integer.parseInt(timeout));

        // connect
        final String url = settings.get("url"); // can be like "jdbc:mysql://%host%:%port%/%dbname%?verifyServerCertificate=%vsc%&useSSL=%usessl%&requireSSL=%requiressl%"
        return DriverManager.getConnection(url, settings.get("user"), settings.get("password"));
    }

}