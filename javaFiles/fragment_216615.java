public void checkAndNotify() {

    /* fire onStart() */
    for (FileAlterationListener listener : listeners) {
        listener.onStart(this);
    }
    ...