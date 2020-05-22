import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CustomSlider extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainPane = new BorderPane();
        mainPane.setPadding(new Insets(15));

        Slider slider = new Slider();
        slider.setId("color-slider");

        mainPane.setCenter(slider);

        Scene scene = new Scene(mainPane, 250, 400);
        stage.setScene(scene);
        stage.show();

        StackPane trackPane = (StackPane) slider.lookup(".track");

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                String style = String.format("-fx-background-color: linear-gradient(to right, #2D819D %d%%, #969696 %d%%);",
                        new_val.intValue(), new_val.intValue());
                trackPane.setStyle(style);
            }
        });

        trackPane.setStyle("-fx-background-color: linear-gradient(to right, #2D819D 0%, #969696 0%);");

    }

    public static void main(String[] args) {
        launch(args);
    }
}