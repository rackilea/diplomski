import junit.framework.TestCase;

public class GraphTest extends TestCase {
    public void testIsPredecessor() throws Exception {
        Graph<Integer> graph = new Graph<Integer>();
        Vertex<Integer> zero = new Vertex<Integer>(0, "zero");
        Vertex<Integer> one = new Vertex<Integer>(1, "one");
        Vertex<Integer> two = new Vertex<Integer>(2, "two");
        graph.addVertex(zero);
        graph.addVertex(one);
        graph.addVertex(two);
        graph.addEdge(zero, one);
        graph.addEdge(one, two);
        assertTrue(graph.isPredecessor(zero, one));
        assertFalse(graph.isPredecessor(one, zero));
    }
}