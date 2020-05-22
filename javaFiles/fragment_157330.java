public class FolderWork implements Runnable {
    private final Executor executor;
    private final File folder;

    private int pendingItems;  // guarded by monitor lock on this instance

    public FolderWork(Executor executor, File folder) {
        this.executor = executor;
        this.folder = folder;
    }

    @Override
    public void run() {
        for (File file : folder.listFiles()) {
            enqueueMoreWork(file);
        }
    }

    public synchronized void enqueueMoreWork(File file) {
        pendingItems++;
        executor.execute(new FileWork(file, this));
    }

    public synchronized void markWorkItemCompleted() {
        pendingItems--;
        notifyAll();
    }

    public synchronized boolean hasPendingWork() {
        return pendingItems > 0;
    }

    public synchronized void awaitCompletion() {
       while (pendingItems > 0) {
           wait();
       }
    }
}

public class FileWork implements Runnable {
    private final File file;
    private final FolderWork parent;

    public FileWork(File file, FolderWork parent) {
        this.file = file;
        this.parent = parent;
    }

    @Override
    public void run() {
        try {
           // do some work with the file

           if (/* found more work to do */) {
               parent.enqueueMoreWork(...);
           }
        } finally {
            parent.markWorkItemCompleted();
        }
    }
}