import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication314 extends Application
{

    Random random = new Random();
    int numberOfRows = 25;
    int numberOfColumns = 25;

    @Override
    public void start(Stage primaryStage)
    {
        List<Circle> circles = new ArrayList();
        for (int i = 0; i < numberOfColumns * numberOfRows; i++) {
            circles.add(new Circle(10, getRandomColor()));
        }

        GridPane gridPane = new GridPane();
        addCirclesToGridPane(gridPane, circles);
        gridPane.setPadding(new Insets(20, 20, 20, 20));

        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((ActionEvent event) -> {
            Collections.shuffle(circles);//Shuffle the List of Circles.
            for(int i = 0; i < numberOfColumns * numberOfRows; i++) 
            { 
                Circle c = circles.get(i); 
                GridPane.setColumnIndex(c, i % numberOfColumns); 
                GridPane.setRowIndex(c, i / numberOfColumns); 
            }
        });

        VBox vBox = new VBox(gridPane, new StackPane(btn));
        vBox.setMaxSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
        StackPane root = new StackPane(vBox);
        root.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        Scene scene = new Scene(root);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    public void addCirclesToGridPane(GridPane gridPane, List<Circle> circles)
    {
        for (int i = 0; i < numberOfColumns * numberOfRows; i++) {
            gridPane.add(circles.get(i), i % numberOfColumns, i / numberOfColumns);
        }
    }

    public Color getRandomColor()
    {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return Color.rgb(r, g, b);
    }
}