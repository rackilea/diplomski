import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.util.iterator.Filter;

public class ListOntClassesExample {
    public static void main(String[] args) {
        OntModel model = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        model.read( "http://pastebin.com/raw.php?i=MaeEbaux" );
        ExtendedIterator<OntClass> it = model.listClasses().filterKeep( new Filter<OntClass>() {
            @Override
            public boolean accept(OntClass o) {
                return o.isURIResource();
            }
        });
        while ( it.hasNext() ) {
            OntClass klass = it.next();
            System.out.println( klass );
        }
    }
}