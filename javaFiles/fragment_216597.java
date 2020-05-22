import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


public class JarFileTreeView extends Application {

    @Override
    public void start(Stage primaryStage) {
        TreeView<JarEntry> tree = new TreeView<>();
        tree.setShowRoot(false);
        TreeItem<JarEntry> root = new TreeItem<>();
        tree.setRoot(root);

        // only display last portion of the path in the cells:
        tree.setCellFactory(tv -> new TreeCell<JarEntry>() {
            @Override
            public void updateItem(JarEntry item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    String[] pathElements = item.getName().split("/");
                    setText(pathElements[pathElements.length - 1]);
                }
            }
        });

        ObjectProperty<JarFile> jarFile = new SimpleObjectProperty<>();
        jarFile.addListener((obs, oldFile, newFile) -> {
            if (newFile == null) {
                root.getChildren().clear();
            } else {
                populateTree(root, newFile);
            }
        });

        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new ExtensionFilter("Jar Files", "*.jar"));
        Button loadButton = new Button("Load...");
        loadButton.setOnAction(e -> {
            File file = chooser.showOpenDialog(primaryStage);
            if (file != null) {
                try {
                    jarFile.set(new JarFile(file));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        BorderPane uiRoot = new BorderPane(tree, null, null, loadButton, null);
        BorderPane.setMargin(loadButton, new Insets(10));
        BorderPane.setAlignment(loadButton, Pos.CENTER);
        Scene scene = new Scene(uiRoot, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void populateTree(TreeItem<JarEntry> root, JarFile file) {
        root.getChildren().clear();
        List<JarEntry> entries = file.stream().collect(Collectors.toList());

        // sort by length of path (i.e. number of components separated by "/"), then by name:
        entries.sort(Comparator
            .comparing((JarEntry entry) -> entry.getName().split("/").length)
            .thenComparing(entry -> {
                String[] pathElements = entry.getName().split("/");
                return pathElements[pathElements.length - 1];
            }));

        for (JarEntry entry : entries) {

            // need to find correct parent for entry. That parent (or any of the ancestors)
            // might not exist yet, so we create it if necessary as we search.

            // Split name up into folder, subfolder, etc:
            List<String> pathElements = Arrays.asList(entry.getName().split("/"));

            // Search for parent. Start at root:
            TreeItem<JarEntry> parent = root;

            // Iterate through all elements except the last, traversing tree:
            for (int i = 0; i < pathElements.size() - 1 ; i++) {

                // name of ancestor entry:
                String matchingName = String.join("/", pathElements.subList(0, i+1));

                final TreeItem<JarEntry> current = parent ;

                // update parent with current parent's descendant, matching appropriate name:
                parent = current.getChildren().stream()
                    .filter(child -> child.getValue().getName().equals(matchingName))
                    .findFirst()
                    // it's possible this ancestor didn't yet exist, so we create it, 
                    // and add it to the correct parent:
                    .orElseGet(() -> {
                       JarEntry newEntry = new JarEntry(matchingName);
                       TreeItem<JarEntry> newItem = new TreeItem<>(newEntry);
                       current.getChildren().add(newItem);
                       return newItem ;
                    });
            }
            // after all that, we have a valid parent:
            parent.getChildren().add(new TreeItem<>(entry));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}