import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ChoiceBoxUpdateExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        ChoiceBox<Item> choiceBox = new ChoiceBox<>();
        ObservableList<Item> items = FXCollections.observableArrayList(
                item -> new Observable[] {item.nameProperty()}); // the extractor
        items.addAll(
                IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Item("Item "+i))
                .collect(Collectors.toList()));
        choiceBox.setItems(items);

        TextField changeSelectedField = new TextField();
        changeSelectedField.disableProperty()
            .bind(Bindings.isNull(choiceBox.getSelectionModel().selectedItemProperty()));
        changeSelectedField.setOnAction(event -> 
            choiceBox.getSelectionModel().getSelectedItem().setName(changeSelectedField.getText()));

        BorderPane root = new BorderPane();
        root.setTop(choiceBox);
        root.setBottom(changeSelectedField);
        Scene scene = new Scene(root, 250, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class Item {
        public final StringProperty name = new SimpleStringProperty();
        public StringProperty nameProperty() {
            return name ;
        }
        public final String getName() {
            return nameProperty().get();
        }
        public final void setName(String name) {
            nameProperty().set(name);
        }
        public Item(String name) {
            setName(name);
        }
        @Override
        public String toString() {
            return getName();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}