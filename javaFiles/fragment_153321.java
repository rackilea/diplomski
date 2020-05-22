import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.query.ParameterizedSparqlString;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.QuerySolutionMap;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.sparql.core.Var;
import com.hp.hpl.jena.sparql.engine.binding.Binding;


public class ReuseResults {

    final static String turtleContent = "" +
            "@prefix : <http://example.org/> .\n" +
            "\n" +
            ":alice :hasName \"Alice\" .\n" +
            ":alice :hasAddress \"4222 Clinton Way\" .\n" +
            ":herman :hasName \"Herman\".\n" +
            ":herman :hasAddress \"1313 Mockingbird Lane\" .\n" +
            ":DrWho :hasAddress \"The TARDIS\"" + 
            "";

    // Read the model from the turtle content
    final static Model model = ModelFactory.createDefaultModel() 
            .read( new ByteArrayInputStream( turtleContent.getBytes()), null, "TURTLE" );

    final static String findAlice = "" +
            "prefix : <http://example.org/>\n" +
            "select ?alice where {\n" +
            "  ?alice :hasName \"Alice\" .\n" +
            "}\n" +
            "";

    final static String findAliceAddress = "" +
            "prefix : <http://example.org/>\n" +
            "select ?address where {\n" +
            "  ?alice :hasAddress ?address .\n" +
            "}\n" +
            "";

    public static void useInitialBindingsFromQuerySolution() throws IOException {
        System.out.println( "== useInitialBindingsFromQuerySolution ==" );
        // execute the query that finds a binding for ?alice.  There should be just one 
        // query solution in the result set.
        final ResultSet aliceResults = QueryExecutionFactory.create( findAlice, model ).execSelect();
        final QuerySolution solution = aliceResults.next();
        // Use the single query solution from the result set as initial bindings for
        // the second query (which uses the variable ?alice).
        final ResultSet addressResults = QueryExecutionFactory.create( findAliceAddress, model, solution ).execSelect();
        ResultSetFormatter.out( addressResults );
    }

    public static void useParameterizedSPARQLString() {
        System.out.println( "== useParameterizedSPARQLString ==" );
        // execute the query that finds a (single) binding for ?alice.  Then create
        // a query solution map containing those results.
        final ResultSet aliceResults = QueryExecutionFactory.create( findAlice, model ).execSelect();
        final QuerySolutionMap map = new QuerySolutionMap();
        map.addAll( aliceResults.next() );
        // Create a ParameterizedSparqlString from the findAliceAddress query string (if this
        // approach were taken, findAliceAddress could actually *be* a Param.SparqlString, of
        // course).
        final ParameterizedSparqlString pss = new ParameterizedSparqlString( findAliceAddress );
        System.out.println( pss.toString() );
        pss.setParams( map );
        System.out.println( pss.toString() );
        // execute the query and show the results
        ResultSetFormatter.out( QueryExecutionFactory.create( pss.toString(), model ).execSelect() );
    }

    final static String findNamed = "" +
            "prefix : <http://example.org/>\n" +
            "select ?person where {\n" +
            "  ?person :hasName [] .\n" +
            "}\n" +
            "";

    final static String findPersonAddress = "" +
            "prefix : <http://example.org/>\n" +
            "select ?address where { " +
            "  ?person :hasAddress ?address .\n" +
            "}\n" +
            "";

    public static void useValuesFromResultSet() { 
        System.out.println( "\n== useValuesFromResultSet ==" );
        final ResultSet namedResults = QueryExecutionFactory.create( findNamed, model ).execSelect();
        final QueryExecution qe = QueryExecutionFactory.create( findPersonAddress, model );
        System.out.println( "=== Query Before Adding VALUES ===\n" + qe.getQuery() );
        // Create a list of the variables from the result set
        List<Var> variables = new ArrayList<>();
        for ( final String varName : namedResults.getResultVars() ) {
            variables.add( Var.alloc( varName ));
        }
        // Create a list of the bindings from the result set.
        List<Binding> values = new ArrayList<>();
        while ( namedResults.hasNext() ) {
            values.add( namedResults.nextBinding() );
        }
        // add a values block to the query
        qe.getQuery().setValuesDataBlock(variables, values);
        System.out.println( "\n=== Query After Adding VALUES ===\n" + qe.getQuery() );
        ResultSetFormatter.out( qe.execSelect() );
    }

    public static void main(String[] args) throws IOException {
        useInitialBindingsFromQuerySolution(); // 1.a.
        useParameterizedSPARQLString();        // 1.b.
        useValuesFromResultSet();              // 2.
    }
}