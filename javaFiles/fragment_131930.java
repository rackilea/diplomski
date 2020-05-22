import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EditableListView extends Application {

    @Override
    public void start(Stage primaryStage) {
        ListView<Client> listViewClients = new ListView<>();
        for (int i= 1 ; i <= 20; i++) {
            Client c = new Client();
            c.setName("Client "+i);
            listViewClients.getItems().add(c);
        }

        listViewClients.setEditable(true);

        listViewClients.setCellFactory(lv -> new ClientListCell());

        // debug:

        Button debug = new Button("Show clients");
        debug.setOnAction(e -> listViewClients.getItems().stream().map(Client::getName).forEach(System.out::println));

        BorderPane root = new BorderPane(listViewClients, null, null, debug, null);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}