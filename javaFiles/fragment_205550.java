public class FileDownloader {

    private final ReadOnlyLongWrapper bytesDownloaded = new ReadOnlyLongWrapper();

    public final long getBytesDownloaded() {
        return bytesDownloaded.get();
    }

    public final ReadOnlyLongProperty bytesDownloadedProperty() {
        return bytesDownloaded.getReadOnlyProperty();
    }

    private long totalBytes ;

    public long getTotalBytes() {
        return totalBytes ;
    }

    // other code as before...

    public boolean downloadSysVersion() {
        // code as before, but periodically call
        bytesDownloaded.set(...);
        // ...
    }

}