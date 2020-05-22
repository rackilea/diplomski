import java.io.InputStream;

import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.repository.util.RDFInserter;
import org.eclipse.rdf4j.repository.util.RDFLoader;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.helpers.AbstractRDFHandler;
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
    public void loadZippedFile1(InputStream in, RDFFormat format) {
        try (RepositoryConnection con = repo.getConnection()) {
            MyRdfInserter inserter = new MyRdfInserter(con);
            RDFLoader loader =
                    new RDFLoader(con.getParserConfig(), con.getValueFactory());
            loader.load(in, "", RDFFormat.NTRIPLES, inserter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class MyRdfInserter extends AbstractRDFHandler {
        RDFInserter rdfInserter;
        int count = 0;

        public MyRdfInserter(RepositoryConnection con) {
            rdfInserter = new RDFInserter(con);
        }

        @Override
        public void handleStatement(Statement st) {
            count++;
            if (count % 100000 == 0)
                System.out.println("Add statement number " + count + "\n"
                        + st.getSubject().stringValue() + " "
                        + st.getPredicate().stringValue() + " "
                        + st.getObject().stringValue());
            rdfInserter.handleStatement(st);
        }
    }
}