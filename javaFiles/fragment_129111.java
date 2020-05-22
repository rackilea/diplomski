import java.util.concurrent.atomic.AtomicInteger;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BindItemsToKeySet extends Application {

    @Override
    public void start(Stage primaryStage) {
        ObservableMap<Integer, Item> itemLookupById = FXCollections.observableHashMap();
        ComboBox<Integer> listenerCombo = new ComboBox<>();
        ComboBox<Integer> bindingCombo = new ComboBox<>();

        itemLookupById.addListener((MapChangeListener.Change<? extends Integer, ? extends Item> c) -> 
            listenerCombo.getItems().setAll(itemLookupById.keySet())
        );

        bindingCombo.itemsProperty().bind(Bindings.createObjectBinding(() ->
            FXCollections.observableArrayList(itemLookupById.keySet()), 
            itemLookupById));

        TextField textField = new TextField();
        textField.setOnAction(e -> {
            if (textField.getText().isEmpty()) {
                return ;
            }
            Item item = new Item(textField.getText());
            itemLookupById.put(item.getId(), item);
            textField.clear();
        });

        textField.setTooltip(new Tooltip("Type an item name and press enter"));

        VBox root = new VBox(10, 
                textField, 
                listenerCombo, 
                bindingCombo);

        root.setPadding(new Insets(10));

        root.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(root, 250, 350));
        primaryStage.show();

    }

    public static class Item {
        private final int id ;
        private final String name ;

        private final static AtomicInteger nextID = new AtomicInteger(1000);

        public Item(String name) {
            this.id = nextID.incrementAndGet();
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}