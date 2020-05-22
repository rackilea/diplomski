import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DeselectableList extends Application {

    @Override
    public void start(Stage primaryStage) {
        ListView<String> list = new ListView<>();
        MultipleSelectionModel<String> selectionModel = list.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        for (int i=1; i<=20; i++) {
            list.getItems().addAll("Item "+i);
        }
        list.setCellFactory(lv -> {
            ListCell<String> cell = new ListCell<>();
            cell.textProperty().bind(cell.itemProperty());
            cell.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
                list.requestFocus();
                if (! cell.isEmpty()) {
                    int index = cell.getIndex();
                    if (selectionModel.getSelectedIndices().contains(index)) {
                        selectionModel.clearSelection(index);
                    } else {
                        selectionModel.select(index);
                    }
                    event.consume();
                }
            });
            return cell ;
        });
        BorderPane root = new BorderPane(list);
        Scene scene = new Scene(root, 150, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}