import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.tinkerpop.blueprints.TransactionalGraph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class OrientApp {

@SuppressWarnings("unchecked")
public static void main(String[] args) {

    TransactionalGraph graph = new OrientGraph("remote:localhost/GratefulDeadConcerts", "admin", "admin");
    Iterable<Vertex> vertices = (Iterable<Vertex>) (((OrientGraph) graph)
            .command(new OCommandSQL("MATCH {class: Person, as: person, where: (age>10)} RETURN $elements"))
            .execute());

    for (Vertex v : vertices) {
        System.out.println(v.getProperty("age").toString());
    }
    System.out.println(graph);
}
}