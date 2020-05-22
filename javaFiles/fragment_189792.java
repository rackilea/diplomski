final int temp = i; // final is necessary to be enclosed in anonymous class
executor.submit(new Runnable() {
    public void run() {
        processId(finalId);
    }
});