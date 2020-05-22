import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SplitTabs extends Application {
    final Lorem lorem = new Lorem();

    final HashMap<Node, SplitPane> splitPanes = new HashMap<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TabPane tabPane = new TabPane();
        //noinspection ResultOfMethodCallIgnored
        IntStream.range(0, 5)
                .mapToObj(i -> createTab(lorem.nextString(1), lorem.nextString(200)))
                .collect(Collectors.toCollection(tabPane::getTabs));

        stage.setScene(new Scene(new StackPane(tabPane)));
        stage.show();
    }

    private Tab createTab(String title, String text) {
        TextArea textArea = new TextArea(text);
        textArea.setWrapText(true);

        Tab tab = new Tab(title);
        tab.setContent(textArea);
        tab.setOnCloseRequest(event -> {
            TabPane tabPane = tab.getTabPane();
            if (tabPane.getTabs().size() <= 1) {
                SplitPane splitPane = splitPanes.get(tabPane);
                if (splitPane == null) {
                    // don't allow the last tab to be closed.
                    event.consume();
                    return;
                }

                int siblingIdx = (splitPane.getItems().indexOf(tabPane) + 1) % 2;
                Node siblingItem = splitPane.getItems().get(siblingIdx);


                Optional<SplitPane> optionalParentSplitPane =
                        splitPanes.values().stream()
                                .filter(searchPane -> searchPane.getItems().contains(splitPane))
                                .findFirst();

                // make the last TabPane the root.
                if (!optionalParentSplitPane.isPresent()) {
                    StackPane stackPane = (StackPane) splitPane.getParent() ;
                    stackPane.getChildren().setAll(siblingItem);
                    splitPanes.clear();
                    return;
                }

                // graft sibling under parent.
                SplitPane parentSplitPane = optionalParentSplitPane.get();

                int idx = parentSplitPane.getItems().indexOf(splitPane);
                parentSplitPane.getItems().set(idx, siblingItem);
                splitPane.getItems().forEach(splitPanes::remove);
                splitPanes.put(siblingItem, parentSplitPane);
            }
        });

        MenuItem splitVertically = new MenuItem("Split Vertically");
        splitVertically.setOnAction(event -> split(title, text, tab, Orientation.HORIZONTAL));
        MenuItem splitHorizontally = new MenuItem("Split Horizontally");
        splitHorizontally.setOnAction(event -> {
            split(title, text, tab, Orientation.VERTICAL);
        });

        tab.setContextMenu(new ContextMenu(
                splitVertically,
                splitHorizontally
        ));

        return tab;
    }

    private void split(String title, String text, Tab tab, Orientation orientation) {
        TabPane tabPane = tab.getTabPane();
        Tab tabCopy = createTab(title, text);
        TabPane newTabPane = new TabPane(tabCopy);
        SplitPane splitPane = new SplitPane(tabPane, newTabPane);
        splitPane.setOrientation(orientation);

        if (splitPanes.isEmpty()) {
            StackPane stackPane = (StackPane) tabPane.getParent();
            stackPane.getChildren().setAll(splitPane);
            splitPanes.put(tabPane, splitPane);
            splitPanes.put(newTabPane, splitPane);
        } else {
            SplitPane parentSplit = splitPanes.get(tabPane);
            int idx = parentSplit.getItems().indexOf(tabPane);
            parentSplit.getItems().set(idx, splitPane);
            splitPanes.remove(tabPane);
            splitPanes.put(splitPane, parentSplit);
            splitPanes.put(tabPane, splitPane);
            splitPanes.put(newTabPane, splitPane);
        }
    }
}

class Lorem {
    private static final String[] IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque hendrerit imperdiet mi quis convallis. Pellentesque fringilla imperdiet libero, quis hendrerit lacus mollis et. Maecenas porttitor id urna id mollis. Suspendisse potenti. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Cras lacus tellus, semper hendrerit arcu quis, auctor suscipit ipsum. Vestibulum venenatis ante et nulla commodo, ac ultricies purus fringilla. Aliquam lectus urna, commodo eu quam a, dapibus bibendum nisl. Aliquam blandit a nibh tincidunt aliquam. In tellus lorem, rhoncus eu magna id, ullamcorper dictum tellus. Curabitur luctus, justo a sodales gravida, purus sem iaculis est, eu ornare turpis urna vitae dolor. Nulla facilisi. Proin mattis dignissim diam, id pellentesque sem bibendum sed. Donec venenatis dolor neque, ut luctus odio elementum eget. Nunc sed orci ligula. Aliquam erat volutpat.".split(" ");
    private int idx = 0;

    public String nextString(int nWords) {
        int end = Math.min(idx + nWords, IPSUM.length);

        StringBuilder result = new StringBuilder();
        for (int i = idx; i < end; i++) {
            result.append(IPSUM[i]).append(" ");
        }

        idx += nWords;
        idx = idx % IPSUM.length;

        return result.toString();
    }
}