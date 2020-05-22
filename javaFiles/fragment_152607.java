@Stateless
public class Repository1 {
   @EJB
   private Repository2 rep2;

   @PersistenceContext(unitName="blah", type = PersistenceContextType.TRANSACTION)
   private EntityManager em;

   @TransactionAttribute
   public void doSomething() {
      // Do something with em
      rep2.doSomethingAgainInTheSameTransaction();
   }
}

@Stateless
public class Repository2 {
   @PersistenceContext(unitName="blah", type = PersistenceContextType.TRANSACTION)
   private EntityManager em;

   @TransactionAttribute
   public void doSomethingAgainInTheSameTransaction() {
      // Do something with em
   }
}