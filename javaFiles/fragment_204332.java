import java.util.HashMap;
import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskMessageUpdateExample extends Application {



    @Override
    public void start(Stage primaryStage) {

        ObservableMap<ClientService, String> messageLookup = FXCollections.observableMap(new HashMap<>());
        ObservableList<String> messages = FXCollections.observableArrayList();

        messageLookup.addListener((Change<? extends ClientService, ? extends String> change) -> {
            if (change.wasAdded()) {
                messages.add(change.getValueAdded());
            }
            if (change.wasRemoved()) {
                messages.remove(change.getValueRemoved());
            }
        });

        Task<Void> serverTask = new Task<Void>() {

            private Random rng = new Random();

            @Override
            public Void call() throws Exception {
                int nClients = rng.nextInt(11);
                for (int i = 1 ; i <= nClients; i++) {
                    Thread.sleep(rng.nextInt(2000)+500);
                    ClientService cs = new ClientService();
                    String clientID = "Client "+i ;
                    updateMessage("Connected "+clientID);
                    cs.messageProperty().addListener((obs, oldMessage, newMessage) -> {
                        messageLookup.put(cs, clientID +": " +newMessage);
                    });
                    Platform.runLater(cs::start);
                }
                return null ;
            }
        };

        Thread t = new Thread(serverTask);
        t.setDaemon(true);
        t.start();

        Label statusLabel =  new Label();
        statusLabel.textProperty().bind(serverTask.messageProperty());

        ListView<String> listView = new ListView<>();
        listView.setItems(new SortedList<String>(messages, String::compareTo));

        VBox root = new VBox(5, listView, statusLabel);
        root.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(root, 250, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static class ClientService extends Service<Void> {

        @Override
        protected Task<Void> createTask() {
            Task<Void> task =  new Task<Void>() {
                @Override
                public Void call() throws InterruptedException {
                   Random rng = new Random();
                   for (int i = 1 ; i <= 10 ; i++) {
                       Thread.sleep((rng.nextInt(1000)+500));
                       updateMessage("Step "+i);
                   }
                   return null ;
                }
            };
            return task ;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}