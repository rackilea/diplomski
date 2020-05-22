// Controller class:
public class MainWindowUi {

    @FXML
    private TreeView<String> traceTree ;

    // ...

    public void initialize() {
        traceTree.setCellFactory(tree -> {
            TreeCell<String> cell = new TreeCell<String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty) ;
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item);
                    }
                }
            };
            cell.setOnMouseClicked(event -> {
                if (! cell.isEmpty()) {
                    TreeItem<String> treeItem = cell.getTreeItem();
                    // do whatever you need with the treeItem...
                }
            });
            return cell ;
        });
    }

    // ... 
}