interface ProgressCallback {
    void progressUpdate(int progress);
}

class BackgroundWorker{

    private int progress;
    private ProgressCallback callback;

    public BackgroundWorker(ProgressCallback progressCallback) {
        this.callback = progressCallback;
    }

    // BackgroundWorker calls to signal the progress
    // update to your main application, by calling
    // its method passed through the callback wrapper
    // class ProgressCallback.
    private void notifyProgressUpdateToMain() {
        callback.progressUpdate(progress);
    }

    // Awesome stuff implemented here

}

class Main {

    public static void main(String[] args) {

        // Implement a new callback "on-the-fly" with the interface
        // as template for a progress callback.
        ProgressUpdate callback = new ProgressUpdate(int progress) {
            @Override
            public void progressUpdate() {
                // The call of the method of this main class
                // is now encapsulated in the callback
                setProgressUpdate(progress);
            }
        };

        // Does awesome stuff in background
        BackgroundWorker worker = new BackgroudWorker(callback);
        worker.start();

        // Do other stuff, while the worker sets the progress

    }

    private setProgressUpdate(int progress) {
        // Magically retrieved progress bar from the GUI
        progressBar.setProgress(progress);
    }

}