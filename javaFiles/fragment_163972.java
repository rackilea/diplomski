package test;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.io.IOException;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * Jung example - vertices appearing in same location
 * 
 * @author Kah
 */
public class StaticLocation {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Setup the example graph.
        Graph<Integer, String> basis = new SparseMultigraph<Integer, String>();
        basis.addVertex(Integer.valueOf(0));
        basis.addVertex(Integer.valueOf(1));
        basis.addVertex(Integer.valueOf(2));
        basis.addEdge("Edge 1", Integer.valueOf(0), Integer.valueOf(1));
        basis.addEdge("Edge 2", Integer.valueOf(0), Integer.valueOf(2));
        basis.addEdge("Edge 3", Integer.valueOf(1), Integer.valueOf(2));

        Transformer<Integer, Point2D> locationTransformer = new Transformer<Integer, Point2D>() {

            @Override
            public Point2D transform(Integer vertex) {
                int value = (vertex.intValue() * 40) + 20;
                return new Point2D.Double((double) value, (double) value);
            }
        };

        StaticLayout<Integer, String> layout = new StaticLayout<Integer, String>(
                basis, locationTransformer);
        layout.setSize(new Dimension(250, 250));
        VisualizationViewer<Integer, String> vv = new VisualizationViewer<Integer, String>(
                layout);

        vv.setPreferredSize(new Dimension(250, 250));

        JFrame frame = new JFrame("Simple Graph View 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        vv.setOpaque(false);
        frame.pack();
        frame.setVisible(true);
    }
}