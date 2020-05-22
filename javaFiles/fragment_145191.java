import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.fxmisc.easybind.EasyBind;
import org.fxmisc.easybind.monadic.PropertyBinding;

public class BidirectionalBindingToNestedProperty extends Application {

    private PropertyBinding<String> selectedValue2;

    @Override
    public void start(Stage primaryStage) {
        TableView<Item> table = new TableView<>();
        TableColumn<Item, String> col1 = new TableColumn<>("Value 1");
        col1.setCellValueFactory(cellData -> cellData.getValue().value1Property());

        table.getColumns().add(col1);

        TextField textField = new TextField();
        selectedValue2 = EasyBind
                .monadic(table.getSelectionModel().selectedItemProperty())
                .selectProperty(Item::value2Property);
        textField.textProperty().bindBidirectional(selectedValue2);

        for (int i = 1 ; i <= 40; i+=2) {
            Item item = new Item(String.valueOf(i), String.valueOf(i + 1));
            item.value2Property().addListener((obs, oldValue, newValue) -> 
                System.out.println("Item with value1 = "+item.getValue1() + " changed value2 from "+oldValue+" to "+newValue));
            table.getItems().add(item);
        }

        BorderPane root = new BorderPane(table, null, null, null, textField);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class Item {
        private final StringProperty value1 = new SimpleStringProperty();
        private final StringProperty value2 = new SimpleStringProperty();

        public Item(String value1, String value2) {
            setValue1(value1);
            setValue2(value2);
        }

        public final StringProperty value1Property() {
            return this.value1;
        }

        public final java.lang.String getValue1() {
            return this.value1Property().get();
        }

        public final void setValue1(final java.lang.String value1) {
            this.value1Property().set(value1);
        }

        public final StringProperty value2Property() {
            return this.value2;
        }

        public final java.lang.String getValue2() {
            return this.value2Property().get();
        }

        public final void setValue2(final java.lang.String value2) {
            this.value2Property().set(value2);
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}