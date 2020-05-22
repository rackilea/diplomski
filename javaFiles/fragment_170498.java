import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

import javafx.application.Application;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class TableWithFormattedLong extends Application {

    private final NumberFormat integerFormat = new DecimalFormat("#,###");

    @Override
    public void start(Stage primaryStage) {
        TableView<Item> table = new TableView<>();
        TableColumn<Item, String> itemColumn = new TableColumn<>("Item");
        itemColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        TableColumn<Item, Number> valueColumn = new TableColumn<>("Value");
        valueColumn.setCellValueFactory(cellData -> cellData.getValue().valueProperty());

        valueColumn.setCellFactory(tc -> new TableCell<Item, Number>() {
            @Override
            protected void updateItem(Number value, boolean empty) {
                super.updateItem(value, empty);
                if (value == null || empty) {
                    setText("");
                } else {
                    setText(integerFormat.format(value));
                }
            }
        });

        table.getColumns().add(itemColumn);
        table.getColumns().add(valueColumn);

        Random rng = new Random();

        for (int i = 1 ; i <= 20 ; i++) {
            table.getItems().add(new Item("Item "+i, rng.nextLong()));
        }

        primaryStage.setScene(new Scene(table, 600, 600));
        primaryStage.show();
    }

    public static class Item {
        private final StringProperty name = new SimpleStringProperty();
        private final LongProperty value = new SimpleLongProperty();

        public Item(String name, long value) {
            setName(name);
            setValue(value);
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


        public final LongProperty valueProperty() {
            return this.value;
        }


        public final long getValue() {
            return this.valueProperty().get();
        }


        public final void setValue(final long value) {
            this.valueProperty().set(value);
        }



    }

    public static void main(String[] args) {
        launch(args);
    }
}