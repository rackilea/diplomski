import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFLanguages;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class RDFSReasoningExample {
    public static void main(String[] args) throws IOException {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.RDFS_MEM_RDFS_INF);
        String content = (""
                + "@prefix : <urn:ex:>.\n"
                + "@prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#>.\n"
                + "\n"
                + ":a rdfs:subClassOf :b .\n"
                + ":b rdfs:subClassOf :c .\n");
        try ( InputStream in = new ByteArrayInputStream(content.getBytes()) ) {
            RDFDataMgr.read(model, in, RDFLanguages.TTL);
        }
        System.out.println("* Write the deductions model");
        RDFDataMgr.write(System.out, model.getDeductionsModel(), RDFLanguages.NT);
        System.out.println("* Write the model");
        RDFDataMgr.write(System.out, model, RDFLanguages.NT);
        System.out.println("* Write the deductions model again");
        RDFDataMgr.write(System.out, model.getDeductionsModel(), RDFLanguages.NT);
    }
}