import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javax.swing.*;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.awt.Point;
public class FxInSwing {
    private JFrame frame;
    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            new FxInSwing().initAndShowGUI();
        });
    }
    /*
     * Builds and displays the JFrame with the JFXPanel.
     * This method is invoked on the Swing Event Dispatch Thread -
     * see the main().
     */
    private void initAndShowGUI() {
        frame = new JFrame("JavaFX in Swing App");
        JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(400, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(new Point(150, 150));
        Platform.runLater(() -> {
            fxPanel.setScene(createScene());
        });
    }
    private Scene createScene() {
        VBox root = new VBox();
        root.setStyle("-fx-background: red;");
        Label label = new Label("hello friend");
        Label other = new Label("hello WORLD!!!");
        root.getChildren().addAll(label, other);
        return new Scene(root);
    }
}