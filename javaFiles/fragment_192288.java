public Downloader getDownloader(Context context, Integer... positions) throws Exception {

    Class<? extends Downloader> mClass = getDownloaderClassName();
    Downloader downloader = mClass.cast(mClass.getConstructors()[0].newInstance(context));
    if (downloader != null)
        downloader.setPositions(positions);

    return downloader;
}

public abstract Class<? extends Downloader> getDownloaderClassName();