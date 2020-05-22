import java.util.concurrent.atomic.AtomicInteger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class JavaFXTestingGround extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ListView<CellData> listView = new ListView();
        listView.setCellFactory((ListView<CellData> param) -> {
            ListCell<CellData> cell = new ListCell<CellData>() {
                TextField textField = new TextField();
                Button button = new Button();
                HBox hBox = new HBox(textField, button);
                {
                    HBox.setHgrow(textField, Priority.ALWAYS);
                }

                @Override
                protected void updateItem(CellData item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        textField.setPromptText(item.getTextFieldPromptText());
                        button.setText(item.getButtonText());
                        button.setOnAction((actionEvent) -> {
                            System.out.println("You clicked " + button.getText() + ". TextField Prompt text is " + textField.getPromptText() + ".");
                        });

                        setGraphic(hBox);
                    } else {
                        setGraphic(null);
                    }
                }
            };
            return cell;
        });        

        AtomicInteger i = new AtomicInteger(1);        
        Button button = new Button("Add Item");
        button.setOnAction((event) -> {
            listView.getItems().add(new CellData("Prompt Text: " + i.get(), "Button: " + i.getAndIncrement()));
        });

        VBox root = new VBox(button, listView);
        stage.setScene(new Scene(root));
        stage.show();
    }    
}