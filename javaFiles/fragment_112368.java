public class Foo {

@PersistenceContext EntityManager em;

@Inject BarImpl bar; //can also use @EJB depending on your environment

public void fail() {
   try {
     //do some thing and throw exception to simulate rollback
      throw new RuntimeException("Exception occured, please rollback");
   } catch(Exception ex) {
     bar.save(ex.getMessage()); // <-- This will store the exception message in a new transaction whilst the other transaction is safely rolledback
     throw ex;
   }
}

@Scope(SESSION)
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER) //default
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class BarImpl implements Bar {

   @PersistenceContext EntityManager em;    
   @Destroy @Remove public void destroy(){}

    public void save(String msg) { 
      MyEntity m = new MyEntity(); 
      m.setMessage(msg); 
      em.persist(m);
    }

}