package example;

import java.io.StringReader;

import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

public class SafwenExample
{
    public static String NS = "http://example.com/example#";

    public static String SOURCE = "@prefix : <http://example.com/example#> .\n" +
            "@prefix owl: <http://www.w3.org/2002/07/owl#>.\n" +
            "@prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>.\n" +
            "@prefix xsd: <http://www.w3.org/2001/XMLSchema#>.\n" +
            ":User a owl:Class.\n" +
            ":gender a owl:DatatypeProperty ;\n" +
            "  rdfs:domain :User ;\n" +
            "  rdfs:range [\n" +
            "    a owl:DataRange ;\n" +
            "    owl:oneOf ( \"male\"^^xsd:string \"female\"^^xsd:string )\n" +
            "].";

    public static void main( String[] args ) {
        new SafwenExample().run();
    }

    public void run() {
        OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        m.read( new StringReader( SOURCE ), null, "Turtle" );

        OntProperty gender = m.getOntProperty( NS + "gender" );

        DataRange genderRange = gender.getRange().as( DataRange.class );
        for (ExtendedIterator<Literal> i = genderRange.listOneOf(); i.hasNext(); ) {
            Literal l = i.next();
            System.out.println( "DataRange has value " + l.getLexicalForm() +
                                " with datatype: " + l.getDatatype() );
        }
    }
}