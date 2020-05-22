import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TooltipApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TextField textField = new TextField();
        textField.setPrefWidth(100.);

        Button button = new Button("Tooltip");

        HBox hBox = new HBox(textField, button);
        hBox.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        Label label = new Label("Empty!");
        label.setVisible(false);
        Pane tooltipPane = new Pane(label);
        tooltipPane.setMouseTransparent(true);

        StackPane stackPane = new StackPane(hBox, tooltipPane);
        stackPane.setPrefSize(600., 400.);

        Scene scene = new Scene(stackPane);

        stage.setScene(scene);
        stage.show();

        button.setOnMouseClicked(event -> {
            if (label.isVisible()) {
                label.setVisible(false);
            } else {
                Bounds sceneBounds = textField.localToScene(textField.getBoundsInLocal());
                label.setLayoutX((sceneBounds.getMinX() + (sceneBounds.getWidth() / 2)) - (label.getWidth() / 2));
                label.setLayoutY(sceneBounds.getMinY() - label.getHeight());
                label.setVisible(true);
            }
        });
    }
}