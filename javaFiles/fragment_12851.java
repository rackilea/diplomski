import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SliderTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane mainPane = new BorderPane();
        mainPane.setPadding(new Insets(15));

        mainPane.setCenter(new ColorSlider());

        Scene scene = new Scene(mainPane, 250, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public class ColorSlider extends StackPane {

        public ColorSlider() {
            getStylesheets().add(this.getClass().getResource("colorSlider.css").toExternalForm());
            Slider slider = new Slider();
            slider.setId("color-slider");

            // The rectangle which shows the progress
            Rectangle progressRec = new Rectangle();
            // Bind both width and height to match the size of Slider
            progressRec.heightProperty().bind(slider.heightProperty().subtract(7));
            progressRec.widthProperty().bind(slider.widthProperty());

            progressRec.setFill(Color.web("#969696"));

            // Make the corners of Rectangle to be rounded
            progressRec.setArcHeight(15);
            progressRec.setArcWidth(15);

            // Listen on value changes on the slider to update the progress (color)
            slider.valueProperty().addListener(new ChangeListener<Number>() {
                public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                    // Using linear gradient we can fill two colors to show the progress
                    // the new_val gets values between 0 - 100
                    String style = String.format("-fx-fill: linear-gradient(to right, #2D819D %d%%, #969696 %d%%);",
                            new_val.intValue(), new_val.intValue());
                    // set the Style
                    progressRec.setStyle(style);
                }
            });

            getChildren().addAll(progressRec, slider);
        }
    }
}