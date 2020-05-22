import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TableWithModelWithPlainList extends Application {

    @Override
    public void start(Stage primaryStage) {
        Model model = new Model();
        for (int i = 1 ; i <= 20 ; i++) {
            model.getItems().add(new Item("Item "+i, i*i));
        }

        TableView<Item> table = new TableView<>();

        // use observable list wrapping model data for table items:
        table.setItems(FXCollections.observableList(model.getItems()));

        // normal table setup:

        table.getColumns().add(column("Item", Item::getName));
        table.getColumns().add(column("Value", Item::getValue));

        // controls to modify table data:

        TextField itemNameField = new TextField();
        Spinner<Integer> spinner = new Spinner<>(1, 1000, 200);
        Button add = new Button("Add");

        EventHandler<ActionEvent> addHandler = e -> {
            table.getItems().add(new Item(itemNameField.getText(), spinner.getValue()));
            itemNameField.clear();
        };
        add.setOnAction(addHandler);
        itemNameField.setOnAction(addHandler);

        Button remove = new Button("Remove");
        remove.disableProperty().bind(table.getSelectionModel().selectedItemProperty().isNull());
        remove.setOnAction(e -> table.getItems().remove(table.getSelectionModel().getSelectedIndex()));

        // checks that model and table are in sync:

        Button debug = new Button("Debug");
        debug.setOnAction(e -> {
            System.out.println("Model has "+model.getItems().size()+" items; table has "+table.getItems().size()+" items");
            for (int i = 0 ; i < model.getItems().size() && i < table.getItems().size(); i++) {
                Item modelItem = model.getItems().get(i);
                Item tableItem = table.getItems().get(i);
                System.out.printf("Index %d: model %s (%d); table %s (%d); equal: %s%n",
                        i, modelItem.getName(), modelItem.getValue(),
                        tableItem.getName(), tableItem.getValue(),
                        tableItem.getValue()==modelItem.getValue() && tableItem.getName().equals(modelItem.getName()));
            }
            System.out.println();
        });

        // layout stuff:

        HBox controls = new HBox(2, itemNameField, spinner, add, remove, debug);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(10));

        BorderPane root = new BorderPane(table);
        root.setBottom(controls);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static <S,T> TableColumn<S,T> column(String title, Function<S,T> property) {
        TableColumn<S,T> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> new ObservableValueBase<T>() {
            @Override
            public T getValue() {
                return property.apply(cellData.getValue());
            };
        });
        return col ;
    }

    public static class Model {
        private List<Item> items ;

        public Model() {
            this.items = new ArrayList<>();
        }

        public List<Item> getItems() {
            return items ;
        }
    }

    public static class Item {
        private String name ;
        private int value ;

        public Item(String name, int value) {
            this.name = name ;
            this.value = value ;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}