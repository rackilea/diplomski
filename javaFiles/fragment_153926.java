private long lastFlush; // Last counter for our flush
private Flusher flusher; // The single flusher used by all threads 

public void write(...)
{
    long latestFlush = flusher.getCount(); // Will use AtomicLong.get() internally
    if (latestFlush > lastFlush)
    {
        flusher.Flush(data);
        // Do whatever else you need
        lastFlush = latestFlush; // Don't use flusher.getCount() here!
    }
    // Now do the normal write
}