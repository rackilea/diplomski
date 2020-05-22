import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LazyTreeTable extends Application {

    @Override
    public void start(Stage primaryStage) {
        TreeTableView<Item> treeTable = new TreeTableView<>();
        TreeTableColumn<Item, String> nameCol = new TreeTableColumn<>("Name");
        nameCol.setCellValueFactory(cellData -> cellData.getValue().getValue().nameProperty());
        nameCol.setPrefWidth(250);
        TreeTableColumn<Item, Number> valueCol = new TreeTableColumn<>("Value");
        valueCol.setCellValueFactory(cellData -> cellData.getValue().getValue().valueProperty());
        valueCol.setPrefWidth(150);
        treeTable.getColumns().addAll(Arrays.asList(nameCol, valueCol));

        treeTable.setRoot(new ItemTreeNode(new Item(1)));

        primaryStage.setScene(new Scene(new BorderPane(treeTable), 400, 600));
        primaryStage.show();
    }

    public static class ItemTreeNode extends TreeItem<Item> {
        private boolean childrenLoaded = false ;

        public ItemTreeNode(Item value) {
            super(value);
        }

        @Override
        public boolean isLeaf() {
            if (childrenLoaded) {
                return getChildren().isEmpty() ;
            }
            return false ;
//          return getChildren().isEmpty();
        }

        @Override
        public ObservableList<TreeItem<Item>> getChildren() {
            if (childrenLoaded) {
                return super.getChildren();
            }

            childrenLoaded = true ;
            if (getValue().getValue() < 100_000) {
                List<TreeItem<Item>> children = new ArrayList<>();
                for (int i = 0 ; i < 10; i++) {
                    children.add(new ItemTreeNode(new Item(getValue().getValue() * 10 + i)));
                }
                super.getChildren().addAll(children);
            } else {
                // great big hack:
                super.getChildren().add(null);
                super.getChildren().clear();
            }
            return super.getChildren() ;
        }
    }

    public static class Item {
        private IntegerProperty value = new SimpleIntegerProperty();
        private StringProperty name = new SimpleStringProperty();

        public Item(String name, int value) {
            setName(name);
            setValue(value);
        }

        public Item(int value) {
            this(String.format("Item %,d", value), value);
        }

        public final IntegerProperty valueProperty() {
            return this.value;
        }

        public final int getValue() {
            return this.valueProperty().get();
        }

        public final void setValue(final int value) {
            this.valueProperty().set(value);
        }

        public final StringProperty nameProperty() {
            return this.name;
        }

        public final java.lang.String getName() {
            return this.nameProperty().get();
        }

        public final void setName(final java.lang.String name) {
            this.nameProperty().set(name);
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}