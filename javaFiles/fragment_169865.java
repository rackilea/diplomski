package filevisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProducerConsumer {

    private Path path;
    private JavaFileVisitor fileVisitor;

    public ProducerConsumer(Path path, JavaFileVisitor visitor) {
        this.path = path;
        this.fileVisitor = visitor;
    }

    public void produce() throws IOException, InterruptedException {
        Files.walkFileTree(path, fileVisitor);
        fileVisitor.setNoMoreItems();
    }

    public void consume() throws InterruptedException {
        while (true) {
            String item = fileVisitor.getQueueItem();
            if(JavaFileVisitor.NO_MORE_ITEMS.equals(item)) {
                break;
            }
            System.out.println(item);
        }
    }
}