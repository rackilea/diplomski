import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class LiveComboBoxTableCellExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Item> table = new TableView<>();

        TableColumn<Item, String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        TableColumn<Item, String> valueCol = new TableColumn<>("Value");
        valueCol.setCellValueFactory(new PropertyValueFactory<>("value"));

        table.getColumns().add(typeCol);
        table.getColumns().add(valueCol);

        typeCol.setCellFactory(new Callback<TableColumn<Item, String>, TableCell<Item, String>>() {

            @Override
            public TableCell<Item, String> call(TableColumn<Item, String> param) {
                return new LiveComboBoxTableCell<>(FXCollections.observableArrayList("String", "Integer"));
            }

        });

        for (int i = 1 ; i <= 10; i++) {
            table.getItems().add(new Item( (i % 2 == 0 ? "String" : "Integer"), "Item "+i));
        }

        Button checkButton = new Button("Run check");
        checkButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                for (Item item : table.getItems()) {
                    System.out.println(item.getType() + " : "+item.getValue());
                }
                System.out.println();
            }

        });

        BorderPane root = new BorderPane();
        root.setCenter(table);
        root.setBottom(checkButton);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class LiveComboBoxTableCell<S,T> extends TableCell<S, T> {

        private final ComboBox<T> comboBox ;

        public LiveComboBoxTableCell(ObservableList<T> items) {
            this.comboBox = new ComboBox<>(items);

            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

            comboBox.valueProperty().addListener(new ChangeListener<T>() {
                @Override
                public void changed(ObservableValue<? extends T> obs, T oldValue, T newValue) {
                    // attempt to update property:
                    ObservableValue<T> property = getTableColumn().getCellObservableValue(getIndex());
                    if (property instanceof WritableValue) {
                        ((WritableValue<T>) property).setValue(newValue);
                    }
                }
            });
        }

        @Override
        public void updateItem(T item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setGraphic(null);
            } else {
                comboBox.setValue(item);
                setGraphic(comboBox);
            }
        }
    }

    public static class Item {
        private final StringProperty type = new SimpleStringProperty();
        private final StringProperty value = new SimpleStringProperty();

        public Item(String type, String value) {
            setType(type);
            setValue(value);
        }

        public final StringProperty typeProperty() {
            return this.type;
        }

        public final String getType() {
            return this.typeProperty().get();
        }

        public final void setType(final String type) {
            this.typeProperty().set(type);
        }

        public final StringProperty valueProperty() {
            return this.value;
        }

        public final String getValue() {
            return this.valueProperty().get();
        }

        public final void setValue(final String value) {
            this.valueProperty().set(value);
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}