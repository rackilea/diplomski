public class Datastore {
  private static PersistenceManagerFactory PMF;
  private static final ThreadLocal<PersistenceManager> PER_THREAD_PM
      = new ThreadLocal<PersistenceManager>();

  public static void initialize() {
     if (PMF != null) {
       throw new IllegalStateException("initialize() already called");
     }
     PMF = JDOHelper.getPersistenceManagerFactory("jdo.properties");
  }

  public static PersistenceManager getPersistenceManager() {
    PersistenceManager pm = PER_THREAD_PM.get();
    if (pm == null) {
      pm = PMF.getPersistenceManager();
      PER_THREAD_PM.set(pm);
    }
    return pm;
  }

  public static void finishRequest() {
    PersistenceManager pm = PER_THREAD_PM.get();
    if (pm != null) {
      PER_THREAD_PM.remove();
      Transaction tx = pm.currentTransaction();
      if (tx.isActive()) {
         tx.rollback();
      }
      pm.close();
    }
  }
}