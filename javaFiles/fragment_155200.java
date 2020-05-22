import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/** @see https://stackoverflow.com/a/37068554/230513 */
public class Main extends Application {

    private final Slider fibSlider = new Slider(0, 10, 0);
    private final Label indexLabel = new Label("Index: ");
    private final Label fibNumLabel = new Label("Fibonacci #: ");
    private final TextField tfIndex = new TextField("0");
    private final TextField tfFibNum = new TextField("0");

    @Override
    public void start(Stage primaryStage) {
        fibSlider.setMajorTickUnit(1);
        fibSlider.setMinorTickCount(0);
        fibSlider.setShowTickLabels(true);
        fibSlider.setShowTickMarks(true);
        fibSlider.setSnapToTicks(true);
        fibSlider.setBlockIncrement(1.0);
        fibSlider.valueProperty().addListener(sl -> {
            long value = ((DoubleProperty) sl).longValue();
            tfIndex.setText(Long.toString(value));
            tfFibNum.setText(Long.toString(fib(value)));
        });

        GridPane mainGPane = buildGPane();
        Scene mainScene = new Scene(mainGPane);
        primaryStage.setTitle("Fibonacci Calculator");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private GridPane buildGPane() {
        GridPane gPane = new GridPane();
        gPane.setAlignment(Pos.CENTER);
        gPane.setPadding(new Insets(10, 10, 10, 10));
        gPane.setHgap(10);
        gPane.setVgap(10);
        gPane.add(fibSlider, 0, 0, 2, 1);
        gPane.add(indexLabel, 0, 1);
        gPane.add(tfIndex, 1, 1);
        gPane.add(fibNumLabel, 0, 2);
        gPane.add(tfFibNum, 1, 2);
        return gPane;
    }

    /**
     * The method for finding the Fibonacci number
     */
    public long fib(long index) {
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return fib(index - 1) + fib(index - 2);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}