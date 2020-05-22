import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuButtonExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        MenuButton menuButton = new MenuButton("Items");
        Label label = new Label();

        Item[] items = new Item[3];
        for (int i = 1 ; i <=3 ; i++) {
            items[i-1] = new Item("Item "+i);
        }

        for (Item item : items) {
            MenuItem menuItem = new MenuItem(item.getName());
            menuItem.setOnAction(e -> item.setTimesChosen(item.getTimesChosen() + 1));
            menuButton.getItems().add(menuItem);
        }

        label.textProperty().bind(Bindings.createStringBinding(() -> 
            Stream.of(items)
                .map(item -> String.format("%s chosen %d times", item.getName(), item.getTimesChosen()))
                .collect(Collectors.joining("\n")), 
            Stream.of(items)
                .map(Item::timesChosenProperty)
                .collect(Collectors.toList()).toArray(new IntegerProperty[0])));

        BorderPane root = new BorderPane();
        root.setCenter(label);
        root.setTop(menuButton);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class Item {
        private final String name ;
        private final IntegerProperty timesChosen = new SimpleIntegerProperty();

        public Item(String name) {
            this.name = name ;
        }

        public String getName() {
            return name ;
        }

        @Override
        public String toString() {
            return getName();
        }

        public final IntegerProperty timesChosenProperty() {
            return this.timesChosen;
        }


        public final int getTimesChosen() {
            return this.timesChosenProperty().get();
        }


        public final void setTimesChosen(final int timesChosen) {
            this.timesChosenProperty().set(timesChosen);
        }



    }

    public static void main(String[] args) {
        launch(args);
    }
}