public void clear() {
    synchronized (mLock) {
        if (mOriginalValues != null) {
            mOriginalValues.clear();
        } else {
            mObjects.clear();
        }
        …
    }
    …
}