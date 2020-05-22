import java.util.Random;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.css.PseudoClass;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TableRowStyleExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Item> table = new TableView<>();

        TableColumn<Item, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getName()));

        TableColumn<Item, Number> valueCol = new TableColumn<>("Value");
        valueCol.setCellValueFactory(cellData -> new ReadOnlyIntegerWrapper(cellData.getValue().getValue()));

        table.getColumns().add(nameCol);
        table.getColumns().add(valueCol);

        final Random rng = new Random();
        IntStream.rangeClosed(1, 20)
            .mapToObj( i -> new Item("Item "+i, rng.nextInt(10)+1))
            .forEach(table.getItems()::add);

        PseudoClass highValuePseudoClass = PseudoClass.getPseudoClass("high-value");
        table.setRowFactory(tv -> new TableRow<Item>() {
            @Override
            public void updateItem(Item item, boolean empty) {
                super.updateItem(item, empty);
                pseudoClassStateChanged(highValuePseudoClass, (! empty) && item.getValue() >= 9);
            }
        });

        Scene scene = new Scene(new BorderPane(table), 600, 400);
        scene.getStylesheets().add("table-row-style-example.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class Item {
        private final String name ;
        private final int value ;

        public Item(String name, int value) {
            this.name = name ;
            this.value = value ;
        }

        public String getName() {
            return name ;
        }

        public int getValue() {
            return value ;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}