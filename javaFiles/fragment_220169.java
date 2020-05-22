import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ComboBoxMouseClickOnCell extends Application {

    @Override
    public void start(Stage primaryStage) {
        ComboBox<String> combo = new ComboBox<>();
        combo.getItems().addAll("One", "Two", "Three");
        combo.setCellFactory(lv -> {
            ListCell<String> cell = new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty ? null : item);
                }
            };
            cell.setOnMousePressed(e -> {
                if (! cell.isEmpty()) {
                    System.out.println("Click on "+cell.getItem());
                }
            });
            return cell ;
        });

        Scene scene = new Scene(new StackPane(combo), 300, 180);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}