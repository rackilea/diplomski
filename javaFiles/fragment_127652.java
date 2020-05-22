import java.io.ByteArrayInputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class ResourcePropertiesExample {
    final static String NS = "http://example.org/";
    final static String modelText = "" +
            "@prefix : <"+NS+"> .\n" +
            ":WorkOrder2 :hasType :Workorder .\n" +
            ":WorkOrder2 :hasResult :Fuselage22 .\n" +
            ":WorkOrder2 :type :NamedIndividual .\n" +
            "";

    public static void main(String[] args) {
        final Model model = ModelFactory.createDefaultModel();
        model.read( new ByteArrayInputStream( modelText.getBytes()), null, "TTL" );
        final Resource workOrder2 = model.getResource( NS+"WorkOrder2" );

        System.out.println( "Using Model.listStatements()" );
        StmtIterator stmts = model.listStatements( workOrder2, null, (RDFNode) null );
        while ( stmts.hasNext() ) {
            System.out.println( stmts.next() );
        }

        System.out.println( "Using Resource.listProperties()" );
        stmts = workOrder2.listProperties();
        while ( stmts.hasNext() ) {
            System.out.println( stmts.next() );
        }
    }
}