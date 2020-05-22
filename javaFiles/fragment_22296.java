package usepool;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
*
* @author brainless
*/
public class ConnectionPool {

private static DataSource datasource;
public static String dbURL = "jdbc:mysql://localhost:3306/"
                + "<YourDataBase>?useUnicode=true&useEncoding=true&characterEncoding=UTF-8";
public static String driverClass = "com.mysql.jdbc.Driver";
public static String userName = "root";
public static String password = "password";
public static boolean jmx = true;
public static boolean testIdle = false;
public static boolean testBorrow = true;
public static boolean testReturn = false;
public static int validationInterval = 30000;
public static int timeBetweenEviction = 30000;
public static int maxActive = 100;
public static int initialSize = 10;
public static int maxWait = 10000;
public static int removeAbandonedTimeout = 60;
public static int minEvictableIdle = 30000;
public static int minIdle = 10;
public static boolean logAbandoned = true;
public static boolean removeAbandoned = true;
public static String jdbcInterceptors = "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
        + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer";

private ConnectionPool() {
}

public static synchronized DataSource getInstance() {
    if (datasource == null) {
        PoolProperties p = new PoolProperties();
        p.setUrl(dbURL);
        p.setDriverClassName(driverClass);
        p.setUsername(userName);
        p.setPassword(password);
        p.setJmxEnabled(jmx);
        p.setTestWhileIdle(testIdle);
        p.setTestOnBorrow(testBorrow);
        p.setTestOnReturn(testReturn);
        p.setValidationInterval(validationInterval);
        p.setTimeBetweenEvictionRunsMillis(timeBetweenEviction);
        p.setMaxActive(maxActive);
        p.setInitialSize(initialSize);
        p.setMaxWait(maxWait);
        p.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        p.setMinEvictableIdleTimeMillis(minEvictableIdle);
        p.setMinIdle(minIdle);
        p.setLogAbandoned(logAbandoned);
        p.setRemoveAbandoned(removeAbandoned);
        p.setJdbcInterceptors(jdbcInterceptors);
        datasource = new DataSource();
        datasource.setPoolProperties(p);
    }
    return datasource;
}

public static synchronized void closePool() {
    if (datasource != null) {
        datasource.close();
    }
}