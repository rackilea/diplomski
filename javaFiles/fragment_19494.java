package com.vsd.server.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.connection.C3P0ConnectionProvider;

public class FailoverConnectionProvider extends C3P0ConnectionProvider {

    String password;
    String username;
    String connectionString;
    String failover_connstring;

    @Override
    public Connection getConnection() throws SQLException {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(connectionString, username, password);
        } catch (Exception ex) {
            conn = DriverManager.getConnection(failover_connstring, username, password);
        }

        if(conn == null){
            throw new IllegalStateException("Database connection was not initialized");
        }

        return conn;

    }

    @Override
    public void configure(Properties properties) throws HibernateException {
        failover_connstring = properties.getProperty("hibernate.connection.failover.url");

        if (StringUtils.isBlank(connectionString)
                && StringUtils.isBlank(failover_connstring)
                && StringUtils.isBlank(username)
                && StringUtils.isBlank(password)) {
            throw new IllegalStateException("Unable to initialize connection provider for hibernate");
        }
    }
}