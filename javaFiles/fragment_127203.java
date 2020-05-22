import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class JobWork {
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void doWork(Entity entity) {
        // do what you would do in the loop with the Entity
        // this runs in a new transaction
    }
}