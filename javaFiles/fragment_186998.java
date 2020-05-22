import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.stream.IntStream;

public class MultiListTable extends Application {
    enum ItemType {
        PipeCable, Element
    }

    @Override public void start(Stage stage) throws IOException {
        TableView<StoredItem> tableView = new TableView<>();

        TableColumn<StoredItem, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setPrefWidth(120);

        tableView.getColumns().add(nameColumn);

        Data data = new Data();

        ChoiceBox<ItemType> choiceBox = new ChoiceBox<>(
                FXCollections.observableArrayList(ItemType.values())
        );

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case PipeCable:
                    Bindings.bindContent(tableView.getItems(), data.getPipeCableList());
                    break;

                case Element:
                    Bindings.bindContent(tableView.getItems(), data.getElementList());
                    break;
            }
        });

        choiceBox.getSelectionModel().select(0);

        Button addPipe = new Button("Add Pipe");
        addPipe.setOnAction(event -> data.getPipeCableList().add(
                new PipeCable("Pipe " + (data.getPipeCableList().size() + 1))
        ));
        IntStream.range(0, 3).forEach(i -> addPipe.fire());

        Button addElement = new Button("Add Element");
        addElement.setOnAction(event -> data.getElementList().add(
                new Element("Element " + (data.getElementList().size() + 1))
        ));
        IntStream.range(0, 2).forEach(i -> addElement.fire());

        HBox controls = new HBox(10, choiceBox, addPipe, addElement);

        VBox layout = new VBox(10, controls, tableView);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    class Data {
        private ObservableList<PipeCable> pipeCableList = FXCollections.observableArrayList();
        private ObservableList<Element> elementList = FXCollections.observableArrayList();

        ObservableList<PipeCable> getPipeCableList() {
            return pipeCableList;
        }

        ObservableList<Element> getElementList() {
            return elementList;
        }
    }

    static public class StoredItem {
        private final ReadOnlyStringWrapper name;

        public StoredItem(String name) {
            this.name = new ReadOnlyStringWrapper(name);
        }

        public String getName() {
            return name.get();
        }

        public ReadOnlyStringProperty nameProperty() {
            return name.getReadOnlyProperty();
        }
    }

    static public class PipeCable extends StoredItem {
        public PipeCable(String name) {
            super(name);
        }
    }

    static public class Element extends StoredItem {
        public Element(String name) {
            super(name);
        }
    }
}