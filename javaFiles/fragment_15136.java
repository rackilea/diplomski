Query query = new Query();
query.setFilterById(enqueue);
Cursor c = dm.query(query);
if (c.moveToFirst()) {

    int downloadStatus = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));

    if (DownloadManager.STATUS_SUCCESSFUL == downloadStatus) {
        // download succeded
    } else if (DownloadManager.STATUS_FAILED == downloadStatus){
        String failedReason = c.getString(c.getColumnIndex(DownloadManager.COLUMN_REASON));
        // handle failures
    }
}