import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Separator;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class JavaFXTestingGround extends Application
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    private StackPane root = new StackPane();
    private Scene scene = new Scene(root, 400, 400);

    @Override
    public void start(Stage primaryStage)
    {
        GridPane gridPane = new GridPane();
        gridPane.add(new Button("0 0"), 0, 0);
        gridPane.add(new Button("2 0"), 2, 0);
        gridPane.add(new Button("4 0"), 4, 0);

        gridPane.add(new Button("0 2"), 0, 2);
        gridPane.add(new Button("2 2"), 2, 2);
        gridPane.add(new Button("4 2"), 4, 2);

        gridPane.add(new Button("0 4"), 0, 4);
        gridPane.add(new Button("2 4"), 2, 4);
        gridPane.add(new Button("4 4"), 4, 4);

        Separator hSeparatorOne = new Separator(Orientation.HORIZONTAL);
        gridPane.add(hSeparatorOne, 0, 1, 5, 1);
        hSeparatorOne.setPrefHeight(10);
        hSeparatorOne.setMaxWidth(Double.MAX_VALUE);
        //hSeparatorOne.setStyle("-fx-background-color: red;");

        Separator hSeparatorTwo = new Separator(Orientation.HORIZONTAL);
        gridPane.add(hSeparatorTwo, 0, 3, 5, 1);
        hSeparatorTwo.setPrefHeight(10);
        hSeparatorTwo.setMaxWidth(Double.MAX_VALUE);
        //hSeparatorTwo.setStyle("-fx-background-color: red;");

        Separator vSeparatorOne = new Separator(Orientation.VERTICAL);
        gridPane.add(vSeparatorOne, 1, 0, 1, 5);
        vSeparatorOne.setPrefWidth(10);
        vSeparatorOne.setMaxHeight(Double.MAX_VALUE);
        //vSeparatorOne.setStyle("-fx-background-color: red;");

        Separator vSeparatorTwo = new Separator(Orientation.VERTICAL);
        gridPane.add(vSeparatorTwo, 3, 0, 1, 5);
        vSeparatorTwo.setPrefWidth(10);
        vSeparatorTwo.setMaxHeight(Double.MAX_VALUE);
        //vSeparatorTwo.setStyle("-fx-background-color: red;");

        ColumnConstraints columnConstraintsColumnZero = new ColumnConstraints(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE, Control.USE_PREF_SIZE, Priority.SOMETIMES, HPos.CENTER, true);
        ColumnConstraints columnConstraintsSeperatorOne = new ColumnConstraints(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE, Control.USE_PREF_SIZE, Priority.SOMETIMES, HPos.CENTER, true);
        ColumnConstraints columnConstraintsColumnTwo = new ColumnConstraints(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE, Control.USE_PREF_SIZE, Priority.SOMETIMES, HPos.CENTER, true);
        ColumnConstraints columnConstraintsSeperatorThree = new ColumnConstraints(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE, Control.USE_PREF_SIZE, Priority.SOMETIMES, HPos.CENTER, true);
        ColumnConstraints columnConstraintsColumnFour = new ColumnConstraints(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE, Control.USE_PREF_SIZE, Priority.SOMETIMES, HPos.CENTER, true);
        gridPane.getColumnConstraints().addAll(columnConstraintsColumnZero, columnConstraintsSeperatorOne, columnConstraintsColumnTwo, columnConstraintsSeperatorThree, columnConstraintsColumnFour);

        RowConstraints rowConstraintsRowZero = new RowConstraints(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE, Control.USE_PREF_SIZE, Priority.SOMETIMES, VPos.CENTER, true);
        RowConstraints rowConstraintsSeperatorOne = new RowConstraints(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE, Control.USE_PREF_SIZE, Priority.SOMETIMES, VPos.CENTER, true);
        RowConstraints rowConstraintsRowTwo = new RowConstraints(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE, Control.USE_PREF_SIZE, Priority.SOMETIMES, VPos.CENTER, true);
        RowConstraints rowConstraintsSeperatorThree = new RowConstraints(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE, Control.USE_PREF_SIZE, Priority.SOMETIMES, VPos.CENTER, true);
        RowConstraints rowConstraintsRowFour = new RowConstraints(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE, Control.USE_PREF_SIZE, Priority.SOMETIMES, VPos.CENTER, true);
        gridPane.getRowConstraints().addAll(rowConstraintsRowZero, rowConstraintsSeperatorOne, rowConstraintsRowTwo, rowConstraintsSeperatorThree, rowConstraintsRowFour);

        gridPane.setMaxSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
        root.getChildren().add(gridPane);

        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}