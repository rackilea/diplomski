@Override
public long getVersion() {
    readLock.lock();
    try {
        // NOTE: I refactored this to return out of the try/finally which is a fine pattern
        return getVersionLocked();
    } finally {
        readLock.unlock();
    }
}
public ResultObject myQuery() {
    //do some work
    readLock.lock();
    ResultObject result;
    try {
      long version = getVersionLocked();
      result = new ResultObject(this.data, version);
      //note: querying version and result should be atomic!
    } finally {
      readLock.unlock();
    }
    //do some more work
    return result;
}
// NOTE: to call this method, we must already be locked
private long getVersionLocked() {
    return this.versionID;
}