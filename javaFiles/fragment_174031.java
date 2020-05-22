import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TreeViewList extends Application {
    private static final int NUM_ITEMS = 10;

    @Override
    public void start(Stage stage) throws IOException {
        ObservableList<TreeItem<String>> items = generateItems();

        ListView<TreeItem<String>> sourceListView = createSourceListView(
                items
        );
        ListView<TreeItem<String>> destListView = createDestListView(
                sourceListView.getSelectionModel().getSelectedItems()
        );

        sourceListView.getSelectionModel().selectIndices(
                3, 5, 6
        );

        HBox layout = new HBox(10, sourceListView, destListView);
        layout.setPadding(new Insets(10));

        stage.setScene(new Scene(layout));
        stage.show();
    }

    private ListView<TreeItem<String>> createSourceListView(
            ObservableList<TreeItem<String>> items
    ) {
        ListView<TreeItem<String>> sourceListView = new ListView<>(items);
        sourceListView.setCellFactory(param -> new ListCell<TreeItem<String>>() {
            @Override
            protected void updateItem(TreeItem<String> item, boolean empty) {
                super.updateItem(item, empty);

                if (empty
                        || item == null
                        || item.getValue() == null
                        || "".equals(item.getValue().trim())) {
                    setText(null);
                    return;
                }

                setText(item.getValue());
            }
        });
        sourceListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        return sourceListView;
    }

    private ListView<TreeItem<String>> createDestListView(
            ObservableList<TreeItem<String>> items
    ) {
        ListView<TreeItem<String>> destListView = new ListView<>(
                items
        );
        destListView.setCellFactory(param -> new ListCell<TreeItem<String>>() {
            TreeView<String> treeView;

            @Override
            protected void updateItem(TreeItem<String> item, boolean empty) {
                super.updateItem(item, empty);

                if (empty
                        || item == null
                        || item.getValue() == null
                        || "".equals(item.getValue().trim())) {
                    setGraphic(null);
                    return;
                }

                if (treeView == null) {
                    treeView = new TreeView<>();
                    treeView.setPrefHeight(100);
                    treeView.setPrefWidth(100);
                }

                treeView.setRoot(item);
                setGraphic(treeView);
            }
        });
        return destListView;
    }

    private ObservableList<TreeItem<String>> generateItems() {
        ObservableList<TreeItem<String>> items = FXCollections.observableArrayList();
        for (int i = 0; i < NUM_ITEMS; i++) {
            TreeItem<String> nextItem = new TreeItem<>(
                    "root-" + i
            );

            for (int j = 0; j < NUM_ITEMS; j++) {
                TreeItem<String> childItem = new TreeItem<>(
                        "child-" + i + "-" +j
                );
                nextItem.getChildren().add(childItem);
            }

            items.add(nextItem);
        }
        return items;
    }

    public static void main(String[] args) {
        launch(args);
    }
}