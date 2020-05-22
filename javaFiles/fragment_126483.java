Directory directory = FSDirectory.open(folder);
    if (directory.fileExists(IndexWriter.WRITE_LOCK_NAME)) {
        directory.clearLock(IndexWriter.WRITE_LOCK_NAME);
        log.warn("Existing write.lock at [" + folder.getAbsolutePath() + "] has been found and removed. This is a likely result of non-gracefully terminated server. Check for index discrepancies!");
    }
    directory.close();