public synchronized void registerDataReloadListener(DataReloadListener listener) {
        mListeners.add(listener);
    }

    public synchronized void unregisterDataReloadListener(DataReloadListener listener) {
        mListeners.remove(listener);
    }