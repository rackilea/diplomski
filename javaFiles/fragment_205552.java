public class FileDownloader {

    private LongConsumer progressUpdate ;

    public void setProgressUpdate(LongConsumer progressUpdate) {
        this.progressUpdate = progressUpdate ;
    }

    private long totalBytes ;

    public long getTotalBytes() {
        return totalBytes ;
    }

    public boolean downloadSysVersion() {
        // periodically do
        if (progressUpdate != null) {
            progressUpdate.accept(...); // pass in number of bytes downloaded
        }
        // ...
    }
}