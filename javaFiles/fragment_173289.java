@Stateless
public class EntityManagerService {

   @Resource
   EJBContext ejbContext;

   @Produces
   public EntityManager produceEM() {

   EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory(ejbContext.getCallerPrincipal().getName());

   return managerFactory.createEntityManager();

   }
}