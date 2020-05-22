import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ProcessListElements extends Application {

    private int count = 0 ;

    @Override
    public void start(Stage primaryStage) {
        ListView<String> listView = new ListView<>();
        for (int i = 0 ; i < 10 ; i++) addElement(listView.getItems());

        Procedure procedure = new Procedure();

        Button startProcessButton = new Button("Start Process");
        Button addItemButton = new Button("Add item");
        Button deleteItemButton = new Button("Delete item");

        TextArea log = new TextArea();

        startProcessButton.setOnAction(e -> {
            log.clear();
            listView.requestFocus();
            new Thread(() -> procedure.process(listView.getItems())).start();
        });

        addItemButton.setOnAction(e -> addElement(listView.getItems()));
        deleteItemButton.setOnAction(e -> listView.getItems().remove(listView.getSelectionModel().getSelectedIndex()));
        deleteItemButton.disableProperty().bind(listView.getSelectionModel().selectedItemProperty().isNull());

        HBox controls = new HBox(5, startProcessButton, addItemButton, deleteItemButton);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(5));


        BorderPane root = new BorderPane(listView, null, log, controls, null);

        procedure.currentlyChosenElementIndexProperty().addListener((obs, oldIndex, newIndex) -> {
            Platform.runLater(() -> 
                listView.getSelectionModel().clearAndSelect(newIndex.intValue()));
        });

        procedure.currentlyChosenElementIndexProperty().addListener((obs, oldIndex, newIndex) -> {
            Platform.runLater(() -> {
                controls.setDisable(newIndex.intValue() != Procedure.NO_ELEMENT);
            });
        });

        procedure.currentlyChosenElementIndexProperty().addListener((obs, oldIndex, newIndex) -> {
            if (oldIndex.intValue() != Procedure.NO_ELEMENT) {
                log.appendText("Processing of element "+oldIndex.intValue()+" complete\n");
            }
            if (newIndex.intValue() != Procedure.NO_ELEMENT) {
                log.appendText("Processing element "+newIndex.intValue()+" started\n");
            }
        });


        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addElement(List<String> list) {
        count++ ;
        list.add("Item "+count);
    }

    public static class Procedure {

        private static final int NO_ELEMENT = - 1; 

        private final ReadOnlyIntegerWrapper currentlyChosenElementIndex = new ReadOnlyIntegerWrapper(NO_ELEMENT);

        public void process(List<?> items) {
            if (Platform.isFxApplicationThread()) {
                throw new IllegalStateException("This method blocks and must not be executed on the FX Application Thread");
            }
            try {
                for (int i = 0 ; i < items.size(); i++) {
                    currentlyChosenElementIndex.set(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            currentlyChosenElementIndex.set(NO_ELEMENT);
        }

        public final ReadOnlyIntegerProperty currentlyChosenElementIndexProperty() {
            return this.currentlyChosenElementIndex.getReadOnlyProperty();
        }


        public final int getCurrentlyChosenElementIndex() {
            return this.currentlyChosenElementIndexProperty().get();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}