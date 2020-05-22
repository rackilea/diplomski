import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class JSONObjectTest {
    public static void main(String[] args) {
        Model model = ModelFactory.createDefaultModel();
        model.read( JSONObjectTest.class.getResourceAsStream( "/jsonoutput.ttl"), null, "N3" );
        model.write( System.out, "RDF/JSON" );
    }
}