import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;

public class TreeWalkerExample {

    public static void main(String[] args) {
        new TreeWalkerExample();
    }

    public TreeWalkerExample() {
        TreeWalker tw = new TreeWalker();
        tw.execute();
        try {
            tw.get();
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
    }

    public class TreeWalker extends SwingWorker<Void, Path> implements FileVisitor<Path> {

        @Override
        protected void process(List<Path> chunks) {
            for (Path p : chunks) {
                System.out.println(p);
            }
        }

        @Override
        protected Void doInBackground() throws Exception {
            Path p = Paths.get(System.getProperty("user.home"));
            System.out.println(p);
            Files.walkFileTree(p, this);
            return null;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            FileVisitResult fvr = FileVisitResult.CONTINUE;
            if (dir.getFileName().toString().startsWith(".")) {
                fvr = FileVisitResult.SKIP_SUBTREE;
            }
            return fvr;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            publish(file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.TERMINATE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }
    }

}