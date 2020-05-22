import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.TopologicalOrderIterator;

public class TransitiveGraphTest
{
    public static void main(String[] args)
    {
        DirectedGraph<String, DefaultEdge> g = 
            createTestGraph();

        Set<DefaultEdge> resultSimple = compute(g);
        Set<DefaultEdge> resultTopological = computeTopological(g);

        System.out.println("Result simple      "+resultSimple);
        System.out.println("Visited            "+debugCounterSimple);
        System.out.println("Result topological "+resultTopological);
        System.out.println("Visited            "+debugCounterTopological);
    }

    private static int debugCounterSimple = 0;
    private static int debugCounterTopological = 0;


    //========================================================================
    // Simple approach: For each edge, check with a BFS whether its vertices
    // are still connected after removing the edge

    private static <V, E> Set<E> compute(DirectedGraph<V, E> g)
    {
        Set<E> result = new LinkedHashSet<E>();
        Set<E> edgeSet = new LinkedHashSet<E>(g.edgeSet());
        for (E e : edgeSet)
        {
            V v0 = g.getEdgeSource(e);
            V v1 = g.getEdgeTarget(e);
            g.removeEdge(e);
            if (!connected(g, v0, v1))
            {
                result.add(e);
            }
            g.addEdge(v0, v1);
        }
        return result;
    }

    private static <V, E> boolean connected(Graph<V, E> g, V v0, V v1)
    {
        BreadthFirstIterator<V, E> i = 
            new BreadthFirstIterator<V, E>(g, v0);
        while (i.hasNext())
        {
            V n = i.next();
            debugCounterSimple++;
            if (n.equals(v1))
            {
                return true;
            }
        }
        return false;

    }


    //========================================================================
    // Topological approach: For each edge, check whether its vertices
    // are still connected after removing the edge, using a BFS that
    // is "constrained", meaning that it does not traverse past 
    // vertices whose topological index is greater than the end
    // vertex of the edge

    private static <V, E> Set<E> computeTopological(DirectedGraph<V, E> g)
    {
        Map<V, Integer> indices = computeTopologicalIndices(g);
        Set<E> result = new LinkedHashSet<E>();
        Set<E> edgeSet = new LinkedHashSet<E>(g.edgeSet());
        for (E e : edgeSet)
        {
            V v0 = g.getEdgeSource(e);
            V v1 = g.getEdgeTarget(e);
            boolean constrainedConnected =
                constrainedConnected(g, v0, v1, indices);
            if (!constrainedConnected)
            {
                result.add(e);
            }
        }        
        return result;
    }

    private static <V, E> Map<V, Integer> computeTopologicalIndices(
        DirectedGraph<V, E> g)
    {
        Queue<V> q = new ArrayDeque<V>();
        TopologicalOrderIterator<V, E> i = 
            new TopologicalOrderIterator<V, E>(g, q);
        Map<V, Integer> indices = new LinkedHashMap<V, Integer>();
        int index = 0;
        while (i.hasNext())
        {
            V v = i.next();
            indices.put(v, index);
            index++;
        }
        return indices;
    }


    private static <V, E> boolean constrainedConnected(
        DirectedGraph<V, E> g, V v0, V v1, Map<V, Integer> indices)
    {
        Integer indexV1 = indices.get(v1);
        Set<V> visited = new LinkedHashSet<V>();
        Queue<V> q = new LinkedList<V>();
        q.add(v0);
        while (!q.isEmpty())
        {
            V v = q.remove();
            debugCounterTopological++;
            if (v.equals(v1))
            {
                return true;
            }
            Set<E> outs = g.outgoingEdgesOf(v);
            for (E out : outs)
            {
                V ev0 = g.getEdgeSource(out);
                V ev1 = g.getEdgeTarget(out);
                if (ev0.equals(v0) && ev1.equals(v1))
                {
                    continue;
                }
                V n = g.getEdgeTarget(out);
                if (visited.contains(n))
                {
                    continue;
                }
                Integer indexN = indices.get(n);
                if (indexN <= indexV1)
                {
                    q.add(n);
                }
                visited.add(n);
            }
        }
        return false;
    }

    private static DirectedGraph<String, DefaultEdge> createTestGraph()
    {
        DirectedGraph<String, DefaultEdge> g =
            new SimpleDirectedGraph<String, DefaultEdge>(DefaultEdge.class);

        String v0 = "0";
        String v1 = "1";
        String v2 = "2";
        String v3 = "3";
        String v4 = "4";

        g.addVertex(v0);
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);

        g.addEdge(v0, v1);
        g.addEdge(v0, v3);
        g.addEdge(v1, v2);
        g.addEdge(v3, v4);
        g.addEdge(v4, v2);

        g.addEdge(v0, v2);
        g.addEdge(v0, v4);
        g.addEdge(v3, v2);

        return g;
    }



}