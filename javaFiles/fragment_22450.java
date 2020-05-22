import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDFS;


public class RegioneExample {
    public static void main(String[] args) {
        String ns = "http://stackoverflow.com/q/24084473/1281433/";

        Model model = ModelFactory.createDefaultModel();

        Resource soggetto = model.createResource( ns+"soggetto" );
        Resource piemonte = model.createResource( ns+"Piemonte" );

        Property nome = model.createProperty( ns+"Nome" );
        Property regione = model.createProperty( ns+"Regione" );

        soggetto.addProperty( nome, "Vercelli" );
        soggetto.addProperty( regione, piemonte );
        piemonte.addProperty( RDFS.label, "Piemonte" );

        RDFDataMgr.write( System.out, model, Lang.RDFXML );
    }
}