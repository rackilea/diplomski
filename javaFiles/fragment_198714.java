@Override
public synchronized AbstractStatusHandler getWorkbenchErrorHandler() {
    if (myStatusHandler == null) {
        myStatusHandler = new MyStatusHandler();
    }
    return myStatusHandler;
}