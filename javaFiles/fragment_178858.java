import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TreeTableViewInheritableCheckBoxes extends Application {

    @Override
    public void start(Stage primaryStage) {
        TreeTableView<Info> table = new TreeTableView<>();
        table.setEditable(true);

        TreeTableColumn<Info, Boolean> infoCol = new TreeTableColumn<>("Info");
        infoCol.setPrefWidth(200);

        infoCol.setCellValueFactory(cellData -> cellData.getValue().getValue().onHoldProperty());
        infoCol.setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(infoCol));
        table.getColumns().add(infoCol);

        TreeItem<Info> root = createTreeItem(new Info());

        buildTree(root, 0);

        table.setRoot(root);

        primaryStage.setScene(new Scene(new BorderPane(table), 250, 400));
        primaryStage.show();
    }

    private void buildTree(TreeItem<Info> parent, int depth) {
        if (depth > 2) return ;
        for (int i = 0; i < 5; i++) {
            TreeItem<Info> item = createTreeItem(new Info());
            parent.getChildren().add(item);
            buildTree(item, depth + 1);
        }
    }

    private TreeItem<Info> createTreeItem(Info info) {
        TreeItem<Info> item = new TreeItem<>(info);
        info.onHoldProperty().addListener((obs, wasOnHold, isNowOnHold) -> {
            if (isNowOnHold) {
                item.getChildren().forEach(child -> child.getValue().setOnHold(true));
            }
        });
        return item ;
    }

    public static class Info {
        private final BooleanProperty onHold;

        public Info(){
            this.onHold = new SimpleBooleanProperty(false);
        }
        public Boolean getOnHold(){
            return onHold.get();
        }
        public void setOnHold(Boolean onHold) {
            this.onHold.set(onHold);
        }
        public BooleanProperty onHoldProperty(){
            return onHold;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}