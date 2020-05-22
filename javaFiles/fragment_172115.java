import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ResponsiveLayout extends Application
{

    RadioButton radioButton1 = new RadioButton("Radio button 1");
    RadioButton radioButton2 = new RadioButton("Radio button 2");
    RadioButton radioButton3 = new RadioButton("Radio button 3");
    HBox hBox = new HBox(radioButton1, radioButton2, radioButton3);
    StackPane stackPane = new StackPane(hBox);
    VBox vBox = new VBox();
    boolean isHBox = true;
    double controlWidth = -1;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        hBox.setMaxSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
        stackPane.setAlignment(Pos.CENTER_LEFT);

        VBox container = new VBox(stackPane, new TextArea());

        Scene scene = new Scene(container, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        container.widthProperty().addListener((obs, oldWidth, newWidth) -> updateOrientation(newWidth));
    }

    private void updateOrientation(Number paneWidth)
    {
        if (isHBox) {
            if (hBox.getWidth() == stackPane.getWidth()) {
                controlWidth = hBox.getWidth();
                vBox.getChildren().addAll(hBox.getChildren());
                stackPane.getChildren().clear();
                stackPane.getChildren().add(vBox);
                isHBox = false;
            }
        }
        else {
            if (controlWidth <= stackPane.getWidth()) {
                hBox.getChildren().addAll(vBox.getChildren());
                stackPane.getChildren().clear();
                stackPane.getChildren().add(hBox);
                isHBox = true;
            }
        }
    }

}