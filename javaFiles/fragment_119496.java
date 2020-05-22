import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Button add = new Button("Add Check boxes");

        GridPane gpane = new GridPane();
        gpane.setHgap(10); gpane.setVgap(10);
        String[] strings = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        add.setOnAction(e-> {
            addCheckboxes(gpane, strings, 3);
        });

        BorderPane root = new BorderPane(gpane);
        root.setBottom(add);
        primaryStage.setScene(new Scene(root, 150,150));
        primaryStage.show();
    }

    private void addCheckboxes(GridPane gpane, String[] strings, int colums){
        int row = 0, col = 0;

        for(String s: strings){
            gpane.add(new CheckBox(s), col, row);
            col = ++col % colums;
            row = col == 0 ? ++row : row;
        }
    }

    public static void main(final String[] args) {
        launch(args);
    }
}