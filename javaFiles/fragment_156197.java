import java.io.InputStream;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Resource;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.event.base.NotifyingRepositoryConnectionWrapper;
import org.eclipse.rdf4j.repository.event.base.RepositoryConnectionListenerAdapter;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.sail.memory.MemoryStore;

public class MyTripleStore {

    Repository repo;

    /**
     * Creates an inmemory triple store
     * 
     */
    public MyTripleStore() {
        repo = new SailRepository(new MemoryStore());
        repo.initialize();
    }

    /**
     * @param in gzip compressed data on an inputstream
     * @param format the format of the streamed data
     */
    public void loadZippedFile(InputStream in, RDFFormat format) {
        System.out.println("Load zip file of format " + format);
        try (NotifyingRepositoryConnectionWrapper con =
                new NotifyingRepositoryConnectionWrapper(repo, repo.getConnection());) {
            RepositoryConnectionListenerAdapter myListener =
                    new RepositoryConnectionListenerAdapter() {
                        private long count = 0;
                        @Override
                        public void add(RepositoryConnection arg0, Resource arg1, IRI arg2, 
                                         Value arg3, Resource... arg4) {
                            count++;
                            if (count % 100000 == 0)
                                    System.out.println("Add statement number " + count + "\n" 
                                    + arg1+ " " + arg2 + " " + arg3);
                        }
                    };
            con.addRepositoryConnectionListener(myListener);
            con.add(in, "", format);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}