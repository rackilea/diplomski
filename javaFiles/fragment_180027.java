// to add two elements in a row, you must hold the lock.
synchronized(mAction) {
    mAction.add(x);
    // without holding the lock, anything could happen in between
    mAction.add(y);
}