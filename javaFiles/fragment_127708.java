public class EntityManagerFactoryHelper {

    private static EntityManagerFactory factory;

    static {
        try {
           // Set up factory right here
        } catch(ExceptionInInitializerError e) {
            throw e;
        }
    }

    public static EntityManagerFactory getFactory() {
        return this.factory;
    }

}