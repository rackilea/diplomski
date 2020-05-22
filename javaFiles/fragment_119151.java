final BlockingQueue<Boolean> queue = new ArrayBlockingQueue<Boolean>(1);
this.runOnUiThread(new Runnable() {
    public void run() {
        // Assuming you have ConfirmUser method which returns boolean
        queue.add(ConfirmUser(message));
    }
});


Boolean result = null;
try {
    // This will block until something will be added to the queue
    result = queue.take();
} catch (InterruptedException e) {
    // deal with it
}