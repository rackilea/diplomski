import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

public class TreeFromPaths extends Application {

    private final List<String> paths = Arrays.asList(
            "input1",
            "input2.sub1",
            "input2.sub2",
            "input2.sub2.subsub1",
            "input2.sub3",
            "input3",
            "input3.sub1",
            "input3.sub1.subsub1",
            "input3.sub1.subsub1.subsubsub1",
            "input3.sub2"
    );

    private <S,T> TreeView<T> createTree(
            List<S> paths, 
            Function<S, ? extends Iterable<T>> pathSplitter, 
            T rootValue) {

        TreeItem<T> root = new TreeItem<>(rootValue);
        populateTree(paths, pathSplitter, root);
        TreeView<T> tree = new TreeView<>(root);
        tree.setShowRoot(false);
        return tree;
    }

    private <S,T> void populateTree(
            List<S> paths, 
            Function<S, ? extends Iterable<T>> pathSplitter, 
            TreeItem<T> root) {

        for (S path : paths) {
            TreeItem<T> current = root ;
            for (T component : pathSplitter.apply(path)) {
                current = getOrCreateChild(current, component);
            }
        }
    }

    private <T> TreeItem<T> getOrCreateChild(TreeItem<T> parent, T value) {
        for (TreeItem<T> child : parent.getChildren()) {
            if (value.equals(child.getValue())) {
                return child ;
            }
        }
        TreeItem<T> newChild = new TreeItem<>(value);
        parent.getChildren().add(newChild);
        return newChild ;
    }

    @Override
    public void start(Stage primaryStage) {

        Function<String, List<String>> pathSplitter = 
            path -> Arrays.asList(path.split("\\."));

        TreeView<String> treeView = createTree(paths, pathSplitter, "root");

        primaryStage.setScene(new Scene(treeView, 400, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}