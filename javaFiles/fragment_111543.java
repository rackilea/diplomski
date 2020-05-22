import javafx.beans.InvalidationListener;
import javafx.beans.WeakInvalidationListener;
import javafx.css.PseudoClass;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.CheckBoxTreeItem.TreeModificationEvent;
import javafx.scene.control.cell.CheckBoxTreeCell;

public class MyCheckBoxTreeCell<T> extends CheckBoxTreeCell<T> {

    private static final PseudoClass BRANCH = PseudoClass.getPseudoClass("branch");
    private static final PseudoClass THREE_CHILDREN_SELECTED = PseudoClass.getPseudoClass("three-children-selected");

    // event handler to listen for selection changes in direct children
    private final EventHandler<TreeModificationEvent<T>> handler = event -> {
        /*
         * Event starts from the source TreeItem and bubbles up the to the root. This means
         * the first time getTreeItem() != event.getTreeItem() will be the source TreeItem's
         * parent. We then consume the event to stop it propagating to the next parent.
         */
        if (getTreeItem() != event.getTreeItem()) {
            event.consume();
            updatePseudoClasses();
        }
    };
    private final WeakEventHandler<TreeModificationEvent<T>> weakHandler = new WeakEventHandler<>(handler);

    // Used to listen for the "leaf" property of the TreeItem and update the BRANCH pseudo-class
    private final InvalidationListener leafListener = observable -> updatePseudoClasses();
    private final WeakInvalidationListener weakLeafListener = new WeakInvalidationListener(leafListener);

    public MyCheckBoxTreeCell() {
        getStyleClass().add("my-check-box-tree-cell");

        // add listener to "treeItem" property to properly register and unregister
        // the "leafListener" and "handler" instances.
        treeItemProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue != null) {
                oldValue.leafProperty().removeListener(weakLeafListener);
                oldValue.removeEventHandler(CheckBoxTreeItem.checkBoxSelectionChangedEvent(), weakHandler);
            }
            if (newValue != null) {
                newValue.leafProperty().addListener(weakLeafListener);
                newValue.addEventHandler(CheckBoxTreeItem.checkBoxSelectionChangedEvent(), weakHandler);
            }
            updatePseudoClasses();
        });
    }

    private void updatePseudoClasses() {
        /*
         * Assumes the use of CheckBoxTreeItem for each TreeItem in the TreeView.
         *
         * This code is not the most efficient as it will recalculate both the BRANCH and
         * THREE_CHILDREN_SELECTED pseudo-classes each time either possibly changes.
         */
        var item = (CheckBoxTreeItem<T>) getTreeItem();
        if (item == null) {
            pseudoClassStateChanged(BRANCH, false);
            pseudoClassStateChanged(THREE_CHILDREN_SELECTED, false);
        } else {
            pseudoClassStateChanged(BRANCH, !item.isLeaf());

            int selected = 0;
            for (var child : item.getChildren()) {
                // only need to know if *at least* 3 children are selected
                if (((CheckBoxTreeItem<T>) child).isSelected() && ++selected >= 3) {
                    break;
                }
            }
            pseudoClassStateChanged(THREE_CHILDREN_SELECTED, selected >= 3);
        }
    }

    // No need to override "updateItem(T,boolean)" as CheckBoxTreeCell provides
    // the necessary implementation which can be customized via the StringConverter
    // property.

}