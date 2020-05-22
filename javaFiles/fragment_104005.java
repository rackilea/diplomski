import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TableWithSetAllComboBox extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Item> table = new TableView<>();
        TableColumn<Item, String> itemCol = new TableColumn<>("Item");
        itemCol.setCellValueFactory(cellData -> Bindings.createStringBinding(() -> cellData.getValue().getName()));
        table.getColumns().add(itemCol);

        TableColumn<Item, String> choiceCol = new TableColumn<>("Choice");

        ComboBox<Function<Item, StringProperty>> option = new ComboBox<>();

        option.getItems().add(Item::choiceProperty);
        option.getItems().add(Item::choice2Property);

        option.setCellFactory(lv -> createListCell());
        option.setButtonCell(createListCell());

        option.getSelectionModel().select(0);           


        ObservableList<String> choices = FXCollections.observableArrayList("First choice", "Second choice", "Third choice");

        choiceCol.setCellFactory(col -> {
            TableCell<Item, String> cell = new TableCell<>();
            ComboBox<String> combo = new ComboBox<>(choices);
            cell.graphicProperty().bind(Bindings.when(cell.emptyProperty()).then((Node)null).otherwise(combo));
            combo.valueProperty().addListener((obs, oldValue, newValue) -> {
                if (! cell.isEmpty() && newValue != null) {
                    Item item = table.getItems().get(cell.getIndex()) ;
                    StringProperty property = option.getValue().apply(item);
                    property.set(newValue);
                }
            });
            cell.itemProperty().addListener((obs, oldItem, newItem) -> combo.setValue(newItem));
            return cell ;
        });

        choiceCol.setPrefWidth(150);

        table.getColumns().add(choiceCol);

        choiceCol.setCellValueFactory(cellData -> Bindings.createStringBinding( 
                () -> option.getValue().apply(cellData.getValue()).get(), 
                cellData.getValue().choiceProperty(), 
                cellData.getValue().choice2Property(),
                option.valueProperty()));

        choiceCol.setGraphic(option);

        choiceCol.setPrefWidth(200);

        for (int i = 1; i <= 30 ; i++) table.getItems().add(new Item("Item "+i ,choices.get(0)));

        Button debug = new Button("Debug");
        debug.setOnAction(e -> table.getItems().stream().
                map(item -> String.format("%s (%s, %s)", item.getName(), item.getChoice(), item.getChoice2())).
                forEach(System.out::println));

        BorderPane root = new BorderPane(table);
        BorderPane.setMargin(debug, new Insets(5));
        root.setBottom(debug);

        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    private ListCell<Function<Item, StringProperty>> createListCell() {
        return new ListCell<Function<Item, StringProperty>>() {
            @Override
            public void updateItem(Function<Item, StringProperty> item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item.apply(new Item("", "")).getName());
            }
        };
    }

    public static class Item {
        private final String name ;
        private final StringProperty choice ;

        private final StringProperty choice2 ;

        public Item(String name, String choice) {
            this.choice = new SimpleStringProperty(this, "Choice", choice);
            this.choice2 = new SimpleStringProperty(this, "Choice 2", "Second choice");
            this.name = name ;
        }

        public final StringProperty choiceProperty() {
            return this.choice;
        }

        public final java.lang.String getChoice() {
            return this.choiceProperty().get();
        }

        public final void setChoice(final java.lang.String choice) {
            this.choiceProperty().set(choice);
        }

        public String getName() {
            return name;
        }
        public final StringProperty choice2Property() {
            return this.choice2;
        }

        public final java.lang.String getChoice2() {
            return this.choice2Property().get();
        }

        public final void setChoice2(final java.lang.String choice2) {
            this.choice2Property().set(choice2);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}