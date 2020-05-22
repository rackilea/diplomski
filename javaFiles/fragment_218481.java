public static class superThread { // implements Runnable {

    public superThread() {}

    public void run() {}
}

public static class subThread extends superThread {

    public subThread() {
        super();
    }

    public void run() {
        // more stuff
    }
}