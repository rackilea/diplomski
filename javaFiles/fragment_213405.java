import java.util.Objects;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class CachedTableView extends Application {

    @Override
    public void start(Stage primaryStage) {
        CachedObservableList<Item> data = new CachedObservableList<>(100, 100_000_000, i -> new Item(String.format("Item %,d",i)));

        TableView<Item> table = new TableView<>();
        table.setItems(data);

        TableColumn<Item, String> itemCol = new TableColumn<>("Item");
        itemCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        itemCol.setMinWidth(300);
        table.getColumns().add(itemCol);

        Scene scene = new Scene(table, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class Item {
        private final StringProperty name = new SimpleStringProperty();


        public Item(String name) {
            setName(name) ;
        }

        public final StringProperty nameProperty() {
            return this.name;
        }


        public final String getName() {
            return this.nameProperty().get();
        }


        public final void setName(final String name) {
            this.nameProperty().set(name);
        }

        @Override
        public boolean equals(Object o) {
            if (o.getClass() != Item.class) {
                return false ;
            }
            return Objects.equals(getName(), ((Item)o).getName());
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}