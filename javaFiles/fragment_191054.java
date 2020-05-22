import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TableViewCheckBoxTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Item> table = new TableView<>();
        table.setEditable(true);
        table.getColumns().add(createColumn("Name", "name"));
        table.getColumns().add(createColumn("Value", "value"));

        TableColumn<Item, Boolean> activeCol = createColumn("Active", "active");
        table.getColumns().add(activeCol);

        activeCol.setCellFactory(col -> {
            CheckBoxTableCell<Item, Boolean> cell = new CheckBoxTableCell<>(index -> {
                BooleanProperty active = new SimpleBooleanProperty(table.getItems().get(index).isActive());
                active.addListener((obs, wasActive, isNowActive) -> {
                    Item item = table.getItems().get(index);
                    item.setActive(isNowActive);
                });
                return active ;
            });
            return cell ;
        });

        Button listActiveButton = new Button("List active");
        listActiveButton.setOnAction(e -> 
            table.getItems().stream()
                .filter(Item::isActive)
                .map(Item::getName)
                .forEach(System.out::println));

        IntStream.rangeClosed(1, 100)
            .mapToObj(i -> new Item("Item "+i, i, false))
            .forEach(table.getItems()::add);

        BorderPane root = new BorderPane(table, null, null, listActiveButton, null) ;
        BorderPane.setAlignment(listActiveButton, Pos.CENTER);
        BorderPane.setMargin(listActiveButton, new Insets(10));

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private <S,T> TableColumn<S,T> createColumn(String title, String propertyName) {
        TableColumn<S,T> col = new TableColumn<>(title);
        col.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        return col;
    }

    public static class Item implements Serializable {

        private String name ;
        private int value ;
        private boolean active ;

        public Item(String name, int value, boolean active) {
            this.name = name ;
            this.value = value ;
            this.active = active ;
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

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}