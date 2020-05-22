@Override
protected Void call() throws Exception {

    FileDownloader downloader = new FileDownloader();

    downloader.setProgressUpdate(bytesDownloaded -> 
        updateProgress(bytesDownloaded, downloader.getTotalBytes()));

    boolean isDownloaded = downloader.downloadSysVersion();

    // ...
}