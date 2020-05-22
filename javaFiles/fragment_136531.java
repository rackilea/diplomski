import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.StoerWagnerMinimumCut;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class GraphConnectivityTest
{
    public static void main(String[] args)
    {
        UndirectedGraph<String, DefaultEdge> graph =
            new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);

        String v0 = "0";
        String v1 = "1";
        String v2 = "2";
        String v3 = "3";
        String v4 = "4";
        String v5 = "5";
        String v6 = "6";
        String v7 = "7";
        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addVertex(v7);

        graph.addEdge(v0, v1);
        graph.addEdge(v0, v2);
        graph.addEdge(v0, v3);
        graph.addEdge(v1, v2);
        graph.addEdge(v1, v3);
        graph.addEdge(v2, v3);

        graph.addEdge(v4, v5);
        graph.addEdge(v4, v6);
        graph.addEdge(v4, v7);
        graph.addEdge(v5, v6);
        graph.addEdge(v5, v7);
        graph.addEdge(v6, v7);

        graph.addEdge(v1, v4);
        //graph.addEdge(v3, v6);

        ensureConnectivity(graph, 2);
    }

    /**
     * Make sure that the given graph has the specified connectivity.
     * That is: Make sure that more than the given number of vertices
     * have to be removed in order to split the graph into two
     * components.
     * 
     * @param graph The graph
     * @param connectivity The desired connectivity
     */
    private static <V, E> void ensureConnectivity(
        UndirectedGraph<V, E> graph, int connectivity)
    {
        System.out.println("Desired connectivity is "+connectivity);
        while (true)
        {
            StoerWagnerMinimumCut<V, E> m = 
                new StoerWagnerMinimumCut<V, E>(graph);
            Set<V> minCut = m.minCut();

            Set<V> cutVertices = 
                computeCutVertices(graph, minCut);
            System.out.println("Removing "+cutVertices+" will create two components");
            if (cutVertices.size() > connectivity)
            {
                System.out.println("Reached desired connectivity");
                return;
            }
            for (V cutVertex : cutVertices)
            {
                E edge = addBridgeEdge(graph, cutVertex);
                System.out.println("Added edge "+edge);
            }
        }
    }


    /**
     * Creates an edge between two arbitrary neighbors of the
     * given vertex in the given graph that have not yet
     * been connected.
     * 
     * @param graph The graph
     * @param v The vertex
     */
    private static <V, E> E addBridgeEdge(Graph<V, E> graph, V v)
    {
        Set<E> edges = graph.edgesOf(v);
        Set<V> neighbors = new LinkedHashSet<V>();
        for (E edge : edges)
        {
            V v0 = graph.getEdgeSource(edge);
            V v1 = graph.getEdgeTarget(edge);
            neighbors.add(v0);
            neighbors.add(v1);
        }
        neighbors.remove(v);

        List<V> neighborsList = new ArrayList<V>(neighbors);
        for (int i=0; i<neighborsList.size(); i++)
        {
            for (int j=i+1; j<neighborsList.size(); j++)
            {
                V n0 = neighborsList.get(i);
                V n1 = neighborsList.get(j);
                E present = graph.getEdge(n0, n1);
                if (present == null)
                {
                    return graph.addEdge(n0, n1);
                }
            }
        }
        return null;
    }


    /**
     * Compute the vertices in the given graph that have to be 
     * removed from the graph in order to split it into two 
     * components (of which one only contains the given 
     * "minCut" vertices)
     * 
     * @param graph The graph
     * @param minCut The set of vertices on one side of the cut
     * @return The vertices that have to be removed 
     */
    private static <V, E> Set<V> computeCutVertices(
        Graph<V, E> graph, Set<V> minCut)
    {
        Set<V> cutVertices = new LinkedHashSet<V>();
        for (V v : minCut)
        {
            Set<E> edges = graph.edgesOf(v);
            for (E edge : edges)
            {
                V v0 = graph.getEdgeSource(edge);
                V v1 = graph.getEdgeTarget(edge);
                if (minCut.contains(v0) && !minCut.contains(v1))
                {
                    cutVertices.add(v1);
                }
                if (!minCut.contains(v0) && minCut.contains(v1))
                {
                    cutVertices.add(v0);
                }
            }
        }
        return cutVertices;
    }
}