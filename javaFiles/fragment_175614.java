/**
 * Created by jonathan on 27/12/16.
 */
public class Earth {

    public static void main(String[] args){

        Animal a = new Animal(1,"lizard", "gekko", "test");

        HibernateUtil(a);
    }

    public static void HibernateUtil(Animal a){

        // create configuration instance and pass in the
        // hibernate configuration file.
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // version 4.x and up, service registry is being used.
        // The ServiceRegistry scopes the Service.
        // The ServiceRegistry manages the lifecycle of the Service.
        // The ServiceRegistry handles injecting dependencies into the Service
        // (actually both a pull and a push/injection approach are supported).
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        // create a Session factory instance: session factory creates sessions
        // at the request of clients.
        // conceptually, this is a single data store that is thread safe.
        // should be wrapped in a singleton (HibernateUtil being a common convention)
        // the internal state is immutable - once it is created the state is set.
        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

        // get the current session.
        Session session = factory.getCurrentSession();

        // begin transaction
        session.getTransaction().begin();

        // Print out all required information
        System.out.println("Session Is Opened :: "+ session.isOpen());
        System.out.println("Session Is Connected :: "+ session.isConnected());
        session.save(a);


        // commit transaction
        session.getTransaction().commit();




    }



}