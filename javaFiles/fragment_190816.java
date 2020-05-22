public void notifyInvalidated() {
    synchronized(mObservers) {
        for (int i = mObservers.size() - 1; i >= 0; i--) {
            mObservers.get(i).onInvalidated();
        }
    }
}