import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import javafx.scene.control.TreeItem;

public class DirectoryLoader implements Callable<List<? extends TreeItem<Path>>> {

  private static final Comparator<Path> COMPARATOR = (left, right) -> {
    boolean leftIsDir = Files.isDirectory(left);
    if (leftIsDir ^ Files.isDirectory(right)) {
      return leftIsDir ? -1 : 1;
    }
    return left.compareTo(right);
  };

  private final Path directory;

  public DirectoryLoader(Path directory) {
    this.directory = directory;
  }

  @Override
  public List<? extends TreeItem<Path>> call() throws Exception {
    try (Stream<Path> stream = Files.list(directory)) {
      return stream.sorted(COMPARATOR)
          .map(this::toTreeItem)
          .collect(Collectors.toList());
    }
  }

  private TreeItem<Path> toTreeItem(Path path) {
    return Files.isDirectory(path)
           ? new LoadingTreeItem<>(path, new DirectoryLoader(path))
           : new TreeItem<>(path);
  }

}