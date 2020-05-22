public class MyFacade extends AbstractFacade<MyEntityClass> {

     @Resource
     EntityManagerFactory emf;

     @Override
     EntityManager getEntityManager() {
         return emf.createEntityManager();
     }
}