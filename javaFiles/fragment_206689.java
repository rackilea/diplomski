Thread thread = new Thread(this::runInThread);
    thread.setName(...);
    thread.setPriority(...);
    thread.start();
    ...
}

private void runInThread() {
    // something to run in thread
}