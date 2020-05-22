package test;

import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.SpringLayout2;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.io.GraphMLReader;
import edu.uci.ics.jung.io.GraphMLWriter;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.layout.PersistentLayoutImpl;

/**
 * Jung example - vertices appearing in same location
 * 
 * @author Kah
 */
public class PersistentVertices
{

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        // Setup the example graph.
        try
        {
            VisualizationViewer<Integer, String> vv = new VisualizationViewer<Integer, String>(
                    getLayout());

            vv.setPreferredSize(new Dimension(250, 250));

            JFrame frame = new JFrame("Simple Graph View 2");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(vv);
            vv.setOpaque(false);
            frame.pack();
            frame.setVisible(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static Layout<Integer, String> getLayout() throws IOException,
            ClassNotFoundException
    {
        Graph<Integer, String> graph = new SparseMultigraph<Integer, String>();
        File source = new File("C:\\layout.dat");
        SpringLayout2<Integer, String> backing = new SpringLayout2<Integer, String>(
                graph);
        PersistentLayoutImpl<Integer, String> layout = new PersistentLayoutImpl<Integer, String>(
                backing);
        layout.setSize(new Dimension(250, 250));

        // Note that you also need to put the vertices and edges back before
        // restoring.
        graph.addVertex(Integer.valueOf(0));
        graph.addVertex(Integer.valueOf(1));
        graph.addVertex(Integer.valueOf(2));
        graph.addEdge("Edge 1", Integer.valueOf(0), Integer.valueOf(1));
        graph.addEdge("Edge 2", Integer.valueOf(0), Integer.valueOf(2));
        graph.addEdge("Edge 3", Integer.valueOf(1), Integer.valueOf(2));

        if (source.exists())
        {
            layout.restore(source.getAbsolutePath());
        }
        else
        {
            layout.persist(source.getAbsolutePath());
        }
        return layout;
    }
}