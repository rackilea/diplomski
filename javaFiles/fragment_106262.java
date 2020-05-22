public class SampleApplication extends Application {
  static private EntityManagerFactory emf;
  static {
    try {
      emf = Persistence.createEntityManagerFactory("RawdaPU");
    } catch (Exception e) {
      System.out.println("Fatal: Unable to create entity manager factory");
      e.printStackTrace();
    }  
  }

  static public EntityManager createEntityManager() {
    return emf.createEntityManager();
  }

  @Override 
  public void start(Stage stage) {
    . . .
  }
}