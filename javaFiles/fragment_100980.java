import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class CoconutExample {
    public static void main(String[] args) throws IOException {
        final String data = "" +
                "@prefix skos: <http://skos.com/> .\n" +
                "@prefix dbpedia: <http://dbpedia.org/resource/> .\n" +
                "@prefix : <http://stackoverflow.com/q/24247503/1281433> .\n" +
                "\n" +
                ":lovelyBunch skos:closeMatch dbpedia:Coconut .\n" +
                ":uglyBunch skos:closeMatch dbpedia:Banana .\n" +
                "_:blankBunch skos:closeMatch dbpedia:Coconut .\n";

        Model model = ModelFactory.createDefaultModel();
        try ( ByteArrayInputStream in = new ByteArrayInputStream( data.getBytes() ) ) {
            model.read( in, null, "TTL" );
        }

        // Show the model
        System.out.println( "=== Model ===" );
        RDFDataMgr.write( System.out, model, Lang.RDFXML );

        // Ask for triples programmatically
        Property closeMatch = model.createProperty( "http://skos.com/closeMatch" );
        Resource coconut = model.createResource( "http://dbpedia.org/resource/Coconut" );
        System.out.println( "\n=== Subjects ===" );
        for ( StmtIterator s = model.listStatements( null, closeMatch, coconut ); s.hasNext() ; ) {
            System.out.println( "* " + s.next().getSubject() );
        }

        // Ask with a SPARQL query
        String query = "select ?x { ?x <http://skos.com/closeMatch> <http://dbpedia.org/resource/Coconut> }";
        System.out.println( "\n=== SPARQL results ===" );
        ResultSetFormatter.out( QueryExecutionFactory.create( query, model ).execSelect() );
    }
}