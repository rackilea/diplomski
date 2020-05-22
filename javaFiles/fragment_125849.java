SwingWorker requestWorker = new SwingWorker<Object, Object>() {
    protected Object doInBackground() throws Exception{
        // Make your request
        // Process your request
        // You can use setProgress if you know how many values you have...
        // (You will need to use a property listener to monitor
        //  these changes ;))
        // You can also use publish to push updates back to the UI
        return null;
    }

    protected void done() {
        // Remove the "wait" notification...
    }
}