import java.io.ByteArrayInputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class ReadModelFromString {
    public static void main(String[] args) {
        final String modelText = "\n"
                + "<rdf:RDF \n"
                + "    xmlns:res=\"http://www.w3.org/2005/sparql-results#\" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"> \n"
                + "  <rdf:Description rdf:about=\"http://www.w3.org/2005/sparql-results#ResultSet\">\n"
                + "    <res:solution rdf:nodeID=\"r0\"/>\n"
                + "    <res:solution rdf:nodeID=\"r1\"/>\n"
                + "    <res:solution rdf:nodeID=\"r2\"/>\n"
                + "  </rdf:Description>\n" + "</rdf:RDF>";
        final Model model = ModelFactory.createDefaultModel();
        model.read(new ByteArrayInputStream(modelText.getBytes()), null);
        model.write(System.out, "TTL");
    }
}