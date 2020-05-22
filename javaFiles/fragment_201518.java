@Component
public class AuditEventListener implements PersistEventListener, DeleteEventListener, MergeEventListener, PreInsertEventListener {

  @PersistenceContext
  private EntityManager entityManager;

     @Override 
     public boolean onPreInsert(PreInsertEvent event) {
          return false; 
     } 

     @Override
     public void onPersist(PersistEvent event) {
        // you business logic
     }

     ... 
     ...
}