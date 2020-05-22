import com.hp.hpl.jena.query.ParameterizedSparqlString;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFactory;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.ResourceFactory;

public class LondonExample {
    public static void main(String[] args) {
        ParameterizedSparqlString qs = new ParameterizedSparqlString( "" +
                "prefix rdfs:    <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "\n" +
                "select ?resource where {\n" +
                "  ?resource rdfs:label ?label\n" +
                "}" );

        Literal london = ResourceFactory.createLangLiteral( "London", "en" );
        qs.setParam( "label", london );

        System.out.println( qs );

        QueryExecution exec = QueryExecutionFactory.sparqlService( "http://dbpedia.org/sparql", qs.asQuery() );

        // Normally you'd just do results = exec.execSelect(), but I want to 
        // use this ResultSet twice, so I'm making a copy of it.  
        ResultSet results = ResultSetFactory.copyResults( exec.execSelect() );

        while ( results.hasNext() ) {
            // As RobV pointed out, don't use the `?` in the variable
            // name here. Use *just* the name of the variable.
            System.out.println( results.next().get( "resource" ));
        }

        // A simpler way of printing the results.
        ResultSetFormatter.out( results );
    }
}