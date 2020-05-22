package com.example.webapp.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class DatabaseManager {

    // not final anymore and null as default
    private static DatabaseManager instance = null;

    private DatabaseManager() {
        PoolProperties p = new PoolProperties();
        p.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        p.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        p.setUsername("scott");
        p.setPassword("tiger");
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
                + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        javax.sql.DataSource datasource = new DataSource();
        datasource.setPoolProperties(p);

        // use a try-with resource to get rid of the finally block...
        try (Connection con = datasource.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from user");
            int cnt = 1;

            while (rs.next()) {
                System.out.println((cnt++) + ". Host:" + rs.getString("Host")
                        + " User:" + rs.getString("User")
                        + " Password:" + rs.getString("Password"));
            }

            rs.close();
            st.close();
        // ... and handle the exception
        } catch (SQLException e) {
            System.err.println("SQLException while constructing the instance of DatabaseManager");
            e.printStackTrace();
        }
    }

    public static DatabaseManager getInstance() {
        // check for null here:
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }
}