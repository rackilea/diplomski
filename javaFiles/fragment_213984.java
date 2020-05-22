import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CenteredGridPane extends Application {

    @Override
    public void start(Stage main) {
        main.setTitle("GridPane Try");
        GridPane grid = new GridPane();
        Text usr = new Text("USER ID:");
        Text pwd = new Text("PASSWORD:");

        grid.add(usr, 0, 0);
        grid.add(pwd, 0, 1);
        grid.setHgap(10);
        grid.setVgap(10);

        grid.setAlignment(Pos.CENTER);

        Scene msc = new Scene(grid,500,500);

        main.setScene(msc);

        main.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}