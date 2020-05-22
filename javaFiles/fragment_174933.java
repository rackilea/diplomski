import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;
import java.util.stream.*;

public class TreeViewSample extends Application {

    // limits on randomly generated tree size.
    private static final int MAX_DEPTH = 8;
    private static final int MAX_CHILDREN_PER_NODE = 6;
    private static final double EXPANSION_PROPABILITY = 0.2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label numItemsLabel = new Label();

        // create a tree.
        TreeItem<String> rootItem = TreeFactory.createTree(
                MAX_DEPTH,
                MAX_CHILDREN_PER_NODE,
                EXPANSION_PROPABILITY
        );
        rootItem.setExpanded(true);
        TreeView<String> tree = new TreeView<>(rootItem);

        numItemsLabel.setText(
            "Num Items: " + countExpandedItemsUsingStream(rootItem)
        );

        // display the number of items and the tree.
        VBox layout = new VBox(10, numItemsLabel, tree);
        layout.setPadding(new Insets(10));

        stage.setScene(new Scene(layout, 300, 250));
        stage.show();
    }

    // unused method demonstrating alternate solution.
    private long countItemsUsingIterator(TreeItem<String> rootItem) {
        TreeItemIterator<String> iterator = new TreeItemIterator<>(rootItem);

        int nItems = 0;
        while (iterator.hasNext()) {
            nItems++;
            iterator.next();
        }

        return nItems;
    }

    private long countExpandedItemsUsingStream(TreeItem<String> rootItem) {
        return
                TreeItemStreamSupport.stream(rootItem)
                        .filter(TreeItem::isExpanded)
                        .count();
    }

    // unused method demonstrating alternate Jens-Peter Haack solution.
    private long countItemsUsingRecursion(TreeItem<?> node) {
        int count = 1;

        for (TreeItem child : node.getChildren()) {
            count += countItemsUsingRecursion(child);
        }

        return count;
    }

    /**
     * Random Tree generation algorithm.
     */
    private static class TreeFactory {
        private static final Random random = new Random(42);

        static TreeItem<String> createTree(
                int maxDepth,
                int maxChildrenPerNode,
                double expansionProbability
        ) {
            TreeItem<String> root = new TreeItem<>("Root 0:0");
            Stack<DepthTreeItem> itemStack = new Stack<>();
            itemStack.push(new DepthTreeItem(root, 0));

            while (!itemStack.isEmpty()) {
                int numChildren = random.nextInt(maxChildrenPerNode + 1);

                DepthTreeItem nextItem = itemStack.pop();
                int childDepth = nextItem.depth + 1;

                for (int i = 0; i < numChildren; i++) {
                    TreeItem<String> child = new TreeItem<>(
                        "Item " + childDepth + ":" + i
                    );
                    child.setExpanded(random.nextDouble() < expansionProbability);
                    nextItem.treeItem.getChildren().add(child);
                    if (childDepth < maxDepth) {
                        itemStack.push(new DepthTreeItem(child, childDepth));
                    }
                }
            }

            return root;
        }

        static class DepthTreeItem {
            DepthTreeItem(TreeItem<String> treeItem, int depth) {
                this.treeItem = treeItem;
                this.depth = depth;
            }
            TreeItem<String> treeItem;
            int depth;
        }
    }
}

/**
 * Provide a stream of tree items from a root tree item.
 */
class TreeItemStreamSupport {
    public static <T> Stream<TreeItem<T>> stream(TreeItem<T> rootItem) {
        return asStream(new TreeItemIterator<>(rootItem));
    }

    private static <T> Stream<TreeItem<T>> asStream(TreeItemIterator<T> iterator) {
        Iterable<TreeItem<T>> iterable = () -> iterator;

        return StreamSupport.stream(
                iterable.spliterator(),
                false
        );
    }
}

/**
 * Iterate over items in a tree.
 * The tree should not be modified while this iterator is being used.
 *
 * @param <T> the type of items stored in the tree.
 */
class TreeItemIterator<T> implements Iterator<TreeItem<T>> {
    private Stack<TreeItem<T>> stack = new Stack<>();

    public TreeItemIterator(TreeItem<T> root) {
        stack.push(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public TreeItem<T> next() {
        TreeItem<T> nextItem = stack.pop();
        nextItem.getChildren().forEach(stack::push);

        return nextItem;
    }
}