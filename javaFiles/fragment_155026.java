import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BidirectionalSlider extends Application {

    @Override
    public void start(Stage primaryStage) {
        double startingValue = 0.5 ;
        Slider slider = new Slider(0, 1, startingValue);

        slider.styleProperty().bind(Bindings.createStringBinding(() -> {

            double min = slider.getMin();
            double max = slider.getMax();
            double value = slider.getValue() ;

            return createSliderStyle(startingValue, min, max, value);

        }, slider.valueProperty()));

        ProgressBar progressBar1 = new ProgressBar(0.1);
        ProgressBar progressBar2 = new ProgressBar(0.9);

        progressBar1.styleProperty().bind(Bindings.createStringBinding(() -> 
            createSliderStyle(startingValue, 0.0, 1.0, progressBar1.getProgress()), 
            progressBar1.progressProperty()));

        progressBar2.styleProperty().bind(Bindings.createStringBinding(() -> 
            createSliderStyle(startingValue, 0.0, 1.0, progressBar2.getProgress()), 
            progressBar2.progressProperty()));

        VBox root = new VBox(5, slider, progressBar1, progressBar2);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String createSliderStyle(double startingValue, double min, double max, double value) {
        StringBuilder gradient = new StringBuilder("-slider-track-color: ");
        String defaultBG = "derive(-fx-control-inner-background, -5%) " ;
        gradient.append("linear-gradient(to right, ").append(defaultBG).append("0%, ") ;

        double valuePercent = 100.0 * (value - min) / (max - min);

        double startingValuePercent = startingValue * 100.0;


        if (valuePercent > startingValuePercent) {
            gradient.append(defaultBG).append(startingValuePercent).append("%, ");
            gradient.append("green ").append(startingValuePercent).append("%, ");
            gradient.append("green ").append(valuePercent).append("%, ");
            gradient.append(defaultBG).append(valuePercent).append("%, ");
            gradient.append(defaultBG).append("100%); ");
        } else {
            gradient.append(defaultBG).append(valuePercent).append("%, ");
            gradient.append("red ").append(valuePercent).append("%, ");
            gradient.append("red ").append(startingValuePercent).append("%, ");
            gradient.append(defaultBG).append(startingValuePercent).append("%, ");
            gradient.append(defaultBG).append("100%); ");               
        }
        return gradient.toString() ;
    }

    public static void main(String[] args) {
        launch(args);
    }
}