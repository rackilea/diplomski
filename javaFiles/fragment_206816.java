import java.io.File;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class FileBlobFactory {

    private static final long TIMER_PERIOD_MS = 10000;

    private final ReferenceQueue<File> queue;
    private final ConcurrentMap<PhantomReference<File>, String> refs;
    private final Timer reaperTimer;

    public FileBlobFactory() {
        super();
        this.queue = new ReferenceQueue<File>();
        this.refs = new ConcurrentHashMap<PhantomReference<File>, String>();
        this.reaperTimer = new Timer("FileBlob reaper timer", true);
        this.reaperTimer.scheduleAtFixedRate(new FileBlobReaper(), TIMER_PERIOD_MS, TIMER_PERIOD_MS);
    }

    public Blob create() throws IOException {
        File blobFile = File.createTempFile("blob", null);
        //blobFile.deleteOnExit();
        String blobFilePath = blobFile.getCanonicalPath();
        FileBlob blob = new FileBlob(blobFile);
        this.refs.put(new PhantomReference<File>(blobFile, this.queue), blobFilePath);
        return blob;
    }

    public void shutdown() {
        this.reaperTimer.cancel();
    }

    private class FileBlobReaper extends TimerTask {
        @Override
        public void run() {
            System.out.println("FileBlob reaper task begin");
            Reference<? extends File> ref = FileBlobFactory.this.queue.poll();
            while (ref != null) {
                String blobFilePath = FileBlobFactory.this.refs.remove(ref);
                File blobFile = new File(blobFilePath);
                boolean isDeleted = blobFile.delete();
                System.out.println("FileBlob reaper deleted " + blobFile + ": " + isDeleted);
                ref = FileBlobFactory.this.queue.poll();
            }
            System.out.println("FileBlob reaper task end");
        }
    }
}