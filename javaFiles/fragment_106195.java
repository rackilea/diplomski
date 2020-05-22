import org.datanucleus.ExecutionContext;
import org.datanucleus.store.NucleusConnection;

ExecutionContext ec = em.unwrap(ExecutionContext.class);
NucleusConnection conn = ec.getStoreManager().getNucleusConnection(ec);
DB db = (DB)conn.getNativeConnection();