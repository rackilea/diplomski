@Override
protected String doInBackground(String... params) {
    sync.init();
    if (Sync.isOnline()) {
        publishProgress(ObserverStatus.UPLOAD_PENDING);
        sync.upload(); //Upload data
        publishProgress(ObserverStatus.DOWNLOAD_PENDING);
        sync.download(); //Download Data
        publishProgress(ObserverStatus.SYNC_COMPLETED);
    } else {
        setChanged();
        notifyObservers(ObserverStatus.OFFLINE);
    }
    return "Executed";
}