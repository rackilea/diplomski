package filevisitor;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class JavaFileVisitor extends SimpleFileVisitor<Path> {
    private BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);

    public static String NO_MORE_ITEMS = "### NO MORE ITEMS ###";

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (file.toString().endsWith(".java")) {
            try {
                blockingQueue.put(file.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return FileVisitResult.CONTINUE;
    }

    public String getQueueItem() throws InterruptedException {
        String item = blockingQueue.take();
        if(NO_MORE_ITEMS.equals(item)) {
            setNoMoreItems();
        }
        return item;
    }

    public void setNoMoreItems() {
        try {
            blockingQueue.put(NO_MORE_ITEMS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}