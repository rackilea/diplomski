@Override
protected Void call() throws Exception {

    FileDownloader downloader = new FileDownloader();

    downloader.bytesDownloadedProperty().addListener((obs, oldValue, newValue) -> 
        updateProgress(newValue.longValue(), downloader.getTotalBytes()));

    boolean isDownloaded = downloader.downloadSysVersion();

    // ...
}