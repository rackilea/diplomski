import javafx.beans.InvalidationListener;
import javafx.css.PseudoClass;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.util.Callback;

public class CustomTreeCell<T> extends TreeCell<T> {

    private static final PseudoClass ROOT = PseudoClass.getPseudoClass("root");

    public static <T> Callback<TreeView<T>, TreeCell<T>> forTreeView() {
        return treeView -> new CustomTreeCell<>();
    }

    public CustomTreeCell() {
        getStyleClass().add("custom-tree-cell");

        InvalidationListener listener = observable -> {
            boolean isRoot = getTreeView() != null && getTreeItem() == getTreeView().getRoot();
            pseudoClassStateChanged(ROOT, isRoot);
        };

        treeViewProperty().addListener(listener);
        treeItemProperty().addListener(listener);
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            graphicProperty().unbind();
            setGraphic(null);
        } else {
            setText(item.toString()); // Really only works if item is a String. Change as needed.
            graphicProperty().bind(getTreeItem().graphicProperty());
        }
    }

}