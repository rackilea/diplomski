import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

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

        listViewClients.setCellFactory(lv -> {
            TextFieldListCell<Client> cell = new TextFieldListCell<>();
            cell.setConverter(new ClientConverter(cell));
            return cell ;
        });

        // debug:

        Button debug = new Button("Show clients");
        debug.setOnAction(e -> listViewClients.getItems().stream().map(Client::getName).forEach(System.out::println));

        BorderPane root = new BorderPane(listViewClients, null, null, debug, null);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }



    public static class ClientConverter extends StringConverter<Client> {
        private final ListCell<Client> cell;
        public ClientConverter(ListCell<Client> cell) {
            this.cell = cell ;
        }
        @Override
        public String toString(Client client) {
            return client.getName();
        }

        @Override
        public Client fromString(String string) {
            Client client = cell.getItem();
            client.setName(string);
            return client ;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}