Query q = new Query();
    long[] ids = new long[downloadIds.size()];
    int i = 0;
    for (Long id: downloadIds) ids[i++] = id;
    q.setFilterById(ids);
    Cursor c = downloadManager.query(q);
    Set<Long> res = new HashSet<>();
    int columnStatus = c.getColumnIndex(DownloadManager.COLUMN_STATUS);
    while (c.moveToNext()) {
        int status = c.getInt(columnStatus);
        if (status != DownloadManager.STATUS_FAILED && status != DownloadManager.STATUS_SUCCESSFUL) {
            // There is at least one download in progress
        }
    }
    c.close();