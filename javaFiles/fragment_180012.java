import java.nio.file.FileSystems;
import java.nio.file.Path;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

public class App extends Application {

  private static String pathToString(Path p) {
    if (p == null) {
      return "null";
    } else if (p.getFileName() == null) {
      return p.toString();
    }
    return p.getFileName().toString();
  }

  @Override
  public void start(Stage primaryStage) {
    TreeView<Path> tree = new TreeView<>(new TreeItem<>());
    tree.setShowRoot(false);
    tree.setCellFactory(LazyTreeCell.forTreeView("Loading...", App::pathToString));
    TreeViewUtils.installSelectionBugWorkaround(tree);

    for (Path fsRoot : FileSystems.getDefault().getRootDirectories()) {
      tree.getRoot().getChildren().add(new LoadingTreeItem<>(fsRoot, new DirectoryLoader(fsRoot)));
    }

    primaryStage.setScene(new Scene(tree, 800, 600));
    primaryStage.show();
  }

}