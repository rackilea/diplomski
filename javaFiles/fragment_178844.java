import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.DataSourceProxy;

public class JdbcPoolListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent myServletContextEvent) {

        // initialize jdbc-pool datasource to start out with pooled connections 
        try {
            Context myContext = (Context) new InitialContext().lookup("java:comp/env");
            DataSource myDataSource = (DataSource) myContext.lookup("jdbc/cf");
            myServletContextEvent.getServletContext().setAttribute("JdbcPool", myDataSource);
        } catch (NamingException e) {
            System.out.println("Error initializing jdbc-pool datasource");
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent myServletContextEvent) {

    // close datasource from proxy?
    ServletContext myServletContext = myServletContextEvent.getServletContext();
        DataSourceProxy myDataSource = (DataSourceProxy) myServletContext.getAttribute("JdbcPool");
        myDataSource.close();       
        myServletContext.removeAttribute("JdbcPool");

        // deregister JDBC driver to prevent Tomcat 7 from complaining about memory leaks
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                System.out.println(String.format("Deregistering jdbc driver: %s", driver));
            } catch (SQLException e) {
                System.out.println(String.format("Error deregistering driver %s", driver));
                e.printStackTrace();
            }
        }
    }
}