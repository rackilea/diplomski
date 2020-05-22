import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.sessions.server.ServerSession;
import org.eclipse.persistence.internal.sessions.IdentityMapAccessor;
...
JpaEntityManager jem = em.unwrap(JpaEntityManager.class);
ServerSession ss = jem.unwrap(ServerSession.class);
IdentityMapAccessor ima = (IdentityMapAccessor) ss.getIdentityMapAccessor();
...
int count = countCachedEntitiesL2(clazz);