import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private final ListView<String> listView = new ListView<>();
    private final Label label = new Label("Nothing selected");

    private final QueryService service = new QueryService();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        service.setOnSucceeded(wse -> {
            label.setText(service.getValue());
            service.reset();
        });
        service.setOnFailed(wse -> {
            // you could also show an Alert to the user here
            service.getException().printStackTrace();
            service.reset();
        });

        // Simple UI
        VBox root = new VBox(5);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(listView, label);

        // Populate the ListView
        listView.getItems().addAll(
                "One", "Two", "Three", "Four", "Five"
        );

        listView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if (service.isRunning()) {
                service.cancel();
                service.reset();
            }
            service.setSelected(newValue);
            service.start();
        });

        stage.setScene(new Scene(root));
        stage.show();

    }

    private static class QueryService extends Service<String> {

        // Field representing a JavaFX property
        private String selected;

        private void setSelected(String selected) {
            this.selected = selected;
        }

        @Override
        protected Task<String> createTask() {
            return new Task<>() {

                // Task state should be immutable/encapsulated
                private final String selectedCopy = selected;

                @Override
                protected String call() throws Exception {
                    try {
                        long waitTime = (long) (Math.random() * 15_000);
                        System.out.println("Waiting " + waitTime);
                        Thread.sleep(waitTime);
                        return "You have selected item: " + selectedCopy;
                    } catch (InterruptedException ex) {
                        System.out.println("Task interrupted!");
                        throw ex;
                    }
                }

            };
        }

        @Override
        protected void succeeded() {
            System.out.println("Service succeeded.");
        }

        @Override
        protected void cancelled() {
            System.out.println("Service cancelled.");
        }

    }
}