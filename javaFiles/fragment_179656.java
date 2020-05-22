import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RectangleDemo extends Application{

    @Override
    public void start(Stage stage) {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        int columns = 20, rows = 10 , horizontal = 20, vertical = 20;
        Rectangle rect = null;
        for(int i = 0; i < columns; ++i)
        {//Iterate through columns
            for(int j = 0; j < rows; ++j)
            {//Iterate through rows
//              Color choice = chooseColor(rectColors);
                //Method that chooses a color

                rect = new Rectangle(horizontal*j, vertical*i, horizontal, vertical);
                //Create a new rectangle(PosY,PosX,width,height)

                rect.setStroke(Color.RED);
                //Give rectangles an outline so I can see rectangles

                root.getChildren().add(rect);
                //Add Rectangle to board

            }
        }
        scene.setRoot(root);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}