//usual imports
//....
import org.hibernate.impl.SessionImpl;
import org.hibernate.engine.EntityEntry;
import org.hibernate.engine.Status;
import org.hibernate.engine.StatefulPersistenceContext;


Session session = (Session)entityManager.getDelegate();

SessionImpl sessImpl = (SessionImpl) session;
if (((StatefulPersistenceContext) sessImpl.getPersistenceContext()).getEntry(entity).getStatus() == Status.READ_ONLY) {
    dosomething
};