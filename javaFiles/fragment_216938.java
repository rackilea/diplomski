import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;

class Edge
{
    private final String name;

    Edge(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}

public class JungDuplicateEdgesTest
{
    public static void main(String[] args)
    {
        JFrame jf = new JFrame();
        final Graph<String, Edge> g = getGraph();
        VisualizationViewer<String, Edge> vv = 
            new VisualizationViewer<String, Edge>(
                new FRLayout<String, Edge>(g));

        class EdgeLabelTransformer implements Transformer<Edge, String>
        {
            @Override
            public String transform(Edge edge)
            {
                return edge.toString();
            }
        }
        vv.getRenderContext().setEdgeLabelTransformer(
            new EdgeLabelTransformer());

        jf.getContentPane().add(vv);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static Graph<String, Edge> getGraph()
    {
        Graph<String, Edge> g = new DirectedSparseGraph<String, Edge>();
        g.addVertex("v0");
        g.addVertex("v1");
        g.addEdge(new Edge("e0"), "v0", "v1");
        g.addEdge(new Edge("e0"), "v1", "v0");
        return g;
    }
}