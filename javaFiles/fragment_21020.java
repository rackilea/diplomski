import javafx.application.Application;
import javafx.beans.property.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TestFX extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        MyTable table = new MyTable();

        System.getProperties().list(System.out);

        Scene scene = new Scene(table);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(TestFX.class);
    }

    static class MyTable extends AnchorPane {

        private static final Callback NUMBER_CELL_FACTORY = (p) -> new NumberTableCell<>();

        private final Button addRow = new Button("+");
        private final Button removeRow = new Button("-");
        private final TableView<Item> table = new TableView<>();

        MyTable() {
            super();
            initTableView();
            addRow.setOnMouseClicked((e) -> addItem());
            removeRow.setOnMouseClicked((e) -> removeItem());
            VBox vbox = new VBox(5);
            vbox.getChildren().addAll(addRow, removeRow, table);
            getChildren().add(vbox);
        }

        public void addItem() {
            table.getItems().addAll(new Item());
        }

        public void removeItem() {
            if (table.getItems().size() > 0) {
                table.getItems().remove(0);
            }
        }

        private void initTableView() {
            TableColumn<Item, Double> value = new TableColumn<>("Value");
            value.setCellValueFactory(new PropertyValueFactory<>("value"));
            value.setCellFactory(NUMBER_CELL_FACTORY);

            table.getColumns().add(value);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        }
    }

    public static class Item {
        private final DoubleProperty value = new SimpleDoubleProperty();

        public DoubleProperty valueProperty() {
            return value;
        }
    }

    static class NumberTableCell<T> extends TableCell<T, Double> {
        private final Color fill = Color.LIGHTGREY;

        @Override
        protected void updateItem(Double item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
                setTextFill(null);
                return;
            }
            setText(String.valueOf(item));
            setTextFill(fill);
        }
    }
}