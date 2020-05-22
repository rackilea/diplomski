import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ObservableMapTest extends Application {
    // map initializer based on http://stackoverflow.com/a/25829097/1155209
    private static final Map<String, String> extensionToMimeMap =
            Arrays.stream(new String[][]{
                    {"txt", "text/plain"},
                    {"html", "text/html"},
                    {"js", "application/javascript"},
                    {"css", "text/css"}
            }).collect(Collectors.toMap(kv -> kv[0], kv -> kv[1]));

    @Override
    public void start(Stage stage) throws Exception {
        // create an observable wrapper for our map data.
        final ObservableMap<String, String> observableExtensionToMimeMap = FXCollections.observableMap(
                extensionToMimeMap
        );

        // create an ListView based on key items in the map.
        ListView<String> extensionListView = new ListView<>();
        extensionListView.getItems().setAll(extensionToMimeMap.keySet());
        extensionListView.setPrefWidth(100);

        // have the ListView observe the underlying map and modify its items if the key set changes.
        observableExtensionToMimeMap.addListener((MapChangeListener<String, String>) change -> {
            extensionListView.getItems().removeAll(change.getKey());
            if (change.wasAdded()) {
                extensionListView.getItems().add(change.getKey());
            }
        });

        // layout the app.
        Pane layout = new HBox(
                extensionListView,
                createAddExtensionPane(
                        observableExtensionToMimeMap
                )
        );
        layout.setPrefHeight(150);

        // display the app.
        stage.setScene(new Scene(layout));
        stage.show();
    }

    /** Helper factory function to create a UI for adding an element to an map. */
    private GridPane createAddExtensionPane(Map<String, String> map) {
        GridPane addExtensionPane = new GridPane();

        addExtensionPane.add(new Label("Extension:"), 0, 0);
        TextField extensionField = new TextField();
        addExtensionPane.add(extensionField, 1, 0);

        addExtensionPane.add(new Label("Mime Type:"), 0, 1);
        TextField mimeTypeField = new TextField();
        addExtensionPane.add(mimeTypeField, 1, 1);

        Button addButton = new Button("Add");
        addButton.setOnAction(event ->
                map.put(
                        extensionField.getText(),
                        mimeTypeField.getText()
                )
        );
        addExtensionPane.add(addButton, 1, 2);
        addExtensionPane.setPadding(new Insets(10));
        addExtensionPane.setHgap(5);
        addExtensionPane.setVgap(10);

        return addExtensionPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}