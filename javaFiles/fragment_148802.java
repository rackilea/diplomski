package firsthibernateapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new AnnotationConfiguration()
                .setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver")
                .setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/test_hibernate")
                .setProperty("hibernate.connection.username", "root")
                .setProperty("hibernate.connection.password", "root")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.format_sql", "true")
                .setProperty("hibernate.c3p0.acquire_increment", "1")
                .setProperty("hibernate.c3p0.idle_test_period", "100")
                .setProperty("hibernate.c3p0.max_size", "10")
                .setProperty("hibernate.c3p0.max_statements", "0")
                .setProperty("hibernate.c3p0.min_size", "5")
                .setProperty("hibernate.c3p0.timeout", "100")
                .addAnnotatedClass(Users.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Get the persistent instance of the given entity class with the given identifier
        // and prints out its member (myName)

        Users user = (Users) session.get(Users.class, 1);
        System.out.println("The user is " + user.getMyName() + "\n");

        // commit the changes, and close

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}