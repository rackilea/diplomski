import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sun.javafx.scene.control.skin.VirtualContainerBase;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GetTreeCellsByReflection extends Application {

    @SuppressWarnings({ "restriction", "unchecked" })
    @Override
    public void start(Stage primaryStage) {
        TreeView<Integer> tree = createRandomTree(100);
        Button findCells = new Button("Find cells");
        findCells.setOnAction(e -> {
            try {
                Field flowField = VirtualContainerBase.class.getDeclaredField("flow");
                flowField.setAccessible(true);
                Field cellsField = VirtualFlow.class.getDeclaredField("cells");
                cellsField.setAccessible(true);
                Object flow = flowField.get(tree.getSkin());
                ((Iterable<TreeCell<?>>) cellsField.get(flow)).forEach(System.out::println);;
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        });

        BorderPane root = new BorderPane(tree);
        BorderPane.setAlignment(findCells, Pos.CENTER);
        BorderPane.setMargin(findCells, new Insets(5));
        root.setBottom(findCells);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TreeView<Integer> createRandomTree(int numItems) {
        Random rng = new Random();
        TreeItem<Integer> root = new TreeItem<>(0);
        List<TreeItem<Integer>> items = new ArrayList<>();
        items.add(root);
        for (int i = 1 ; i < numItems ; i++) {
            TreeItem<Integer> item = new TreeItem<>(i);
            items.get(rng.nextInt(items.size())).getChildren().add(item);
            items.add(item);
        }
        return new TreeView<>(root);
    }

    public static void main(String[] args) {
        launch(args);
    }
}