import java.awt.Dimension;
import java.awt.Point;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import org.netbeans.api.visual.graph.GraphScene;
import org.netbeans.api.visual.widget.Widget;

public class FXGraphDemo extends Application {

    @Override
    public void start(final Stage stage) {
        final SwingNode swingNode = new SwingNode();
        createAndSetSwingContent(swingNode);

        Scene scene = new Scene(new Group(swingNode), 400, 300);

        stage.setScene(scene);
        stage.show();
    }

    private void createAndSetSwingContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final GraphScene graphScene = new DemoGraphScene();

                String helloNodeID = "Hello";
                String worldNodeID = "World";
                String edge = "edge";

                Widget hello = graphScene.addNode (helloNodeID);
                Widget world = graphScene.addNode (worldNodeID);

                graphScene.addEdge (edge);

                graphScene.setEdgeSource(edge, helloNodeID);
                graphScene.setEdgeTarget(edge, worldNodeID);

                hello.setPreferredLocation (new Point (100, 100));
                world.setPreferredLocation (new Point (300, 200));

                final JComponent sceneView = graphScene.createView();

                final JScrollPane panel = new JScrollPane (sceneView);
                panel.getHorizontalScrollBar().setUnitIncrement (32);
                panel.getHorizontalScrollBar().setBlockIncrement (256);
                panel.getVerticalScrollBar().setUnitIncrement (32);
                panel.getVerticalScrollBar().setBlockIncrement (256); 

                panel.setPreferredSize(new Dimension (400, 300));

                swingNode.setContent(panel);
            }
        });
    }    

    public static void main(String[] args) {
        launch(args);
    }
}