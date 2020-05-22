import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.*;

public class TreeViewSample2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    TreeView<Item> tree;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tree View Sample");

        TreeItem<Item> rootItem = new TreeItem<Item>(new Item("Root"));


        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<Item> item = new TreeItem<Item>(new Item("Item"+i));
            rootItem.getChildren().add(item);
        }

        ContextMenu menu = new ContextMenu();
        MenuItem renameItem = new MenuItem("Rename");
        menu.getItems().add(renameItem);

        tree = new TreeView<Item>(rootItem);
        tree.setContextMenu(menu);
        tree.setEditable(true);

        tree.setCellFactory(new Callback<TreeView<Item>, TreeCell<Item>>() {
            @Override
            public TreeCell<Item> call(TreeView<Item> p) {
                return new TextFieldTreeCell<Item>(new StringConverter<Item>(){

                    @Override
                    public String toString(Item object) {
                        return object.getName();
                    }

                    @Override
                    public Item fromString(String string) {
                        return new Item(string);
                    }
                });
            }
        });
        renameItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tree.edit(tree.getSelectionModel().getSelectedItem());
            }
        });

        tree.setOnEditCommit(new EventHandler<TreeView.EditEvent<Item>>() {
            @Override
            public void handle(TreeView.EditEvent<Item> event) {
                System.out.println("Commit Value");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(tree);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}

class Item {
    private SimpleStringProperty name = new SimpleStringProperty("");
    public SimpleStringProperty nameProperty() {
        return name;
    }

    public final String getName() { return nameProperty().get();}
    public final void setName(String newName) { nameProperty().set(newName);}

    public Item(String name) {
        setName(name);
    }
}