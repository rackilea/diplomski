import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.Paths;
import java.util.logging.*;
import static java.nio.file.StandardOpenOption.*;

public class SharedFileHandler extends Handler {
    private final FileChannel mutex;
    private final String pattern;

    public SharedFileHandler() throws IOException {
        this("%hjava%g.log");
    }

    public SharedFileHandler(String pattern) throws IOException {
        setFormatter(new SimpleFormatter());
        this.pattern = pattern;
        Path p = Paths.get(new File(".").getCanonicalPath(), 
            pattern.replace("%", "") + ".lck");
        mutex = FileChannel.open(p, CREATE, WRITE, DELETE_ON_CLOSE);
    }

    @Override
    public void publish(LogRecord record) {
        if (isLoggable(record)) {
            record.getSourceMethodName(); //Infer caller.
            try {
                FileLock ticket = mutex.lock();
                try {
                    doPublish(ticket, record);
                } finally {
                    ticket.release();
                }
            } catch (IOException | OverlappingFileLockException ex) {
                reportError(null, ex, ErrorManager.WRITE_FAILURE);
            }
        }
    }

    private synchronized void doPublish(FileLock ticket, LogRecord record) throws IOException {
        if (!ticket.isValid()) {
           return;
        }
        final FileHandler h = new FileHandler(pattern, 5242880, 5, true);
        try {
            h.setEncoding(getEncoding());
            h.setErrorManager(getErrorManager());
            h.setFilter((Filter) null);
            h.setFormatter(getFormatter());
            h.setLevel(getLevel());
            h.publish(record);
            h.flush();
        } finally {
            h.close();
        }
    }

    @Override
    public void flush() {
    }

    @Override
    public synchronized void close() throws SecurityException {
        super.setLevel(Level.OFF);
        try {
             mutex.close();
        } catch (IOException ioe) {
            this.reportError(null, ioe, ErrorManager.CLOSE_FAILURE);
        }
    }
}