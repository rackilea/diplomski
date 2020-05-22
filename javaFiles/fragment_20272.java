import org.apache.jena.ontology.OntModel;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

public class jena2 {

    private static void addRaw(OntModel m, Resource s, Property p, Resource o) {
        m.add(ResourceFactory.createStatement(s, p, o));
    }

    public static void main(String[] args) {
        OntModel model = ModelFactory.createOntologyModel();

        Resource A = ResourceFactory.createResource("x:A");
        Resource B = ResourceFactory.createResource("x:B");
        Property prop1 = ResourceFactory.createProperty("x:prop1");
        Property prop2 = ResourceFactory.createProperty("x:prop2");
        Resource whatever = ResourceFactory.createResource("x:whatever");
        Resource other = ResourceFactory.createResource("x:other");
        Resource widget = ResourceFactory.createResource("x:widget");

        addRaw(model, A, RDF.type, RDFS.Class);
        addRaw(model, A, prop1, whatever);
        addRaw(model, B, RDF.type, RDFS.Class);
        addRaw(model, B, prop2, other);
        addRaw(model, B, RDFS.subClassOf, A);
        addRaw(model, widget, RDF.type, B);

        StringBuffer sb = new StringBuffer();

        sb.append("PREFIX x: <x:>");
        sb.append("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>");
        sb.append("SELECT * {");
        sb.append("  x:widget rdf:type ?type .");
        sb.append("  ?type ?props ?all .");
        sb.append("}");

        Query query = QueryFactory.create(sb.toString());
        try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet results = qexec.execSelect();
            for (; results.hasNext(); ) {
                QuerySolution soln = results.nextSolution();
                System.out.println(soln);
            }
        } catch (Exception e) {
            System.out.println("epic fail: " + e);
        }

    }
}