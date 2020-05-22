@Stateless 
public class WidgetDAO implements WidgetDAOLocal {
   @PersistenceUnit
   private EntityManagerFactory emf;
   private EntityManager em;

  public EntityManager getEntityManager() {
     if (emf == null) {
       throw new Exception();
     }
     return emf.createEntityManager;
   }