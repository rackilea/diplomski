class MyClass {
    static void main(String[] args) {
        FaceBook fb = new FaceBook();
        Thread fbThread = new Thread(fb);

        fbThread.start();

        /* ... do stuff ... */

        // Pause the FaceBook thread:
        fb.stopThread();

        /* ... do more stuff ... */

        // Resume the FaceBook thread:
        fb.startThread();

        // etc.

        // When done:
        fbThread.interrupt(); // else the program never exits
    }
}