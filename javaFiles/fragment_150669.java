public class EMF {
    private static EntityManagerFactory emf;
    static {
        emf = Persistence.createEntityManagerFactory("MyEMF");
    }
    public static EntityManager getEM(){
        return emf.createEntityManager();
    }
}