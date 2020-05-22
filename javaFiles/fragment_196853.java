public class EMF {
  private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("name");

  public static EntityManager getEntityManager() {
    return factory.createEntityManager();
  }
}