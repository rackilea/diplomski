public class JpaUtil { 
    private static final EntityManagerFactory emf;

    static {
        try {
            factory = Persistence.createEntityManagerFactory("MyPu");
        } catch (Throwable ex) {
            logger.error("Initial SessionFactory creation failed", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

   ...

}