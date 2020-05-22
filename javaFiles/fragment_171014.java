private QueryResult _latestValidResult;
private final Object _latestValidResultLock = new Object();

//...

    synchronized (_latestValidResultLock ) {
        _latestValidResult = result;
    }