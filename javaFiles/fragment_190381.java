import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Test extends Application {

    public void start(Stage stage) throws Exception {
        HBox pane = new HBox();
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().add("Hello");
        comboBox.getItems().add("World");
        comboBox.setOnAction((e) -> {
             System.out.println(comboBox.getSelectionModel().getSelectedItem());
        });
        Button button = new Button("Select First");
        button.setOnAction((e) -> {
            comboBox.getSelectionModel().selectFirst();
            System.out.println("The button did it!");
        });

        button.fire();

        pane.getChildren().add(comboBox);
        pane.getChildren().add(button);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        comboBox.getSelectionModel().selectFirst();
    }
}