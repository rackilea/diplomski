public void run() {
    try {
        run0();
    } catch(Throwable t) {
        System.err.println("Process dying");
        t.printStackTrace();
    } finally {
        // close all resources
    }
}

private void run0() throws Stuff... {
    // does the real work
}