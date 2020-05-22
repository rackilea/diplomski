import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.vocabulary.RDFS;

public class JenaPropertyExample {
    public static void main(String[] args) {
        final String NS = "http://stackoverflow.com/q/20194409/1281433/";
        final Model model = ModelFactory.createDefaultModel();

        final Property p = model.createResource( NS+"PropertyName", RDF.Property ).as( Property.class );
        p.addProperty( RDFS.domain, model.createResource( NS+"ClassName" ));
        p.addProperty( RDFS.range, RDFS.Literal );

        model.write( System.out, "RDF/XML-ABBREV" );
    }
}