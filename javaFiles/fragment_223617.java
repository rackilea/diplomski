package com.company.app.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public final class ConnectionProvider {
    private static final DataSource DATA_SOURCE;
    static {
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost/test");
            dataSource.setUsername("root");
            dataSource.setPassword("");
            dataSource.setValidationQuery("select now()");
            dataSource.setTestOnBorrow(true);
            dataSource.setRemoveAbandoned(true);
            DATA_SOURCE = dataSource;
        } catch (Throwable t) {
            throw new ExceptionInInitializerError(t);
        }
    }
    public static Connection getConnection() throws SQLException {
        return DATA_SOURCE.getConnection();
    }
}