import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class AlignedCheckBox extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        Label checkboxLabel = new Label("Selected:");
        CheckBox checkBox = new CheckBox();
        checkboxLabel.setLabelFor(checkBox);

        checkboxLabel.setOnMouseClicked(e -> checkBox.setSelected(! checkBox.isSelected()));

        Label textFieldLabel = new Label("Enter text:");
        TextField textField = new TextField();

        grid.addRow(0, checkboxLabel, checkBox);
        grid.addRow(1, textFieldLabel, textField);

        ColumnConstraints leftCol = new ColumnConstraints();
        leftCol.setHalignment(HPos.RIGHT);
        leftCol.setHgrow(Priority.SOMETIMES);

        ColumnConstraints rightCol = new ColumnConstraints();
        rightCol.setHalignment(HPos.LEFT);
        rightCol.setHgrow(Priority.ALWAYS);

        grid.getColumnConstraints().addAll(leftCol, rightCol);

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}