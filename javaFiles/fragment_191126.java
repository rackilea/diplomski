import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ListViewMouseHandlerExample extends Application {

    private int count = 0 ;

    @Override
    public void start(Stage primaryStage) {
        ListView<String> listView = new ListView<>();

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> listView.getItems().add("Item " + (++count)));

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> listView.getItems().remove(listView.getSelectionModel().getSelectedIndex()));
        deleteButton.disableProperty().bind(listView.getSelectionModel().selectedItemProperty().isNull());

        listView.setCellFactory(lv -> {
            ListCell<String> cell = new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(item);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    System.out.println("You clicked on " + cell.getItem());
                    e.consume();
                }
            });
            return cell;
        });

        listView.setOnMouseClicked(e -> {
            System.out.println("You clicked on an empty cell");
        });

        BorderPane root = new BorderPane(listView);
        ButtonBar buttons = new ButtonBar();
        buttons.getButtons().addAll(addButton, deleteButton);
        root.setBottom(buttons);


        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}