import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

// ...

public static void main(String[] args) {
        GraphDatabaseFactory graphDbFactory = new GraphDatabaseFactory();
        GraphDatabaseService graphDb = graphDbFactory.newEmbeddedDatabase("path_to_neo4j_database/your_database_folder");
        try (Transaction tx = graphDb.beginTx()) {
            // use graphDb object to manipulate the DB content
            tx.success();
        }
        graphDb.shutdown();
        System.out.println("Done :) ");
}
// ...