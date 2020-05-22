import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.internal.sessions.UnitOfWorkImpl;
...
JpaEntityManager jem = em.unwrap(JpaEntityManager.class);
UnitOfWorkImpl ouw = jem.unwrap(UnitOfWorkImpl.class);
...
long count = countCachedEntitiesL1(clazz);