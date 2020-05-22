import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Slider fibSlider = new Slider(0, 10, 0);
    private Label indexLabel = new Label("Index: ");
    private int colIndex = 0;
    private int rowIndex = 0;
    private int topIndex = 0;
    private int rightIndex = 0;
    private int leftIndex = 0;
    private int bottomIndex = 0;
    private TextField tfIndex;

    @Override
    public void start(Stage primaryStage) {

        tfIndex = new TextField();

        fibSlider.setMajorTickUnit(1);
        fibSlider.setMinorTickCount(0);
        fibSlider.setShowTickLabels(true);
        fibSlider.setShowTickMarks(true);

        tfIndex.textProperty().bind(fibSlider.valueProperty().asString());

        GridPane mainGPane = buildGPane();
        Scene mainScene = new Scene(mainGPane, 500, 200);

        primaryStage.setTitle("ex");
        primaryStage.setScene(mainScene);
        primaryStage.show();


    }

    private GridPane buildGPane() {
        GridPane gPane = new GridPane();
        gPane.setAlignment(Pos.CENTER);
        gPane.setPadding(new Insets(topIndex = 10, rightIndex = 10,
                bottomIndex = 10, leftIndex = 10));
        gPane.setHgap(2);
        gPane.setVgap(2);
        gPane.add(fibSlider, colIndex = 1, rowIndex = 3);
        gPane.add(indexLabel, colIndex = 1, rowIndex = 5);
        gPane.add(tfIndex, colIndex = 2, rowIndex = 5);

        return gPane;

    }
}