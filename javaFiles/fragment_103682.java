class Task extends SwingWorker<Void, Void> {

    public Task() {
        /*
         * Code placed here will be executed on the EDT.
        */
        jLabel1.setText("Yay I'm on the EDT.");
        execute();
    }

    @Override
    protected Void doInBackground() throws Exception {
        /*
         * Code run here will be executed on a background, "worker" thread that will not interrupt your EDT
         * events. Run your time consuming tasks here.
         *
         * NOTE: DO NOT run ANY Swing (GUI) code here! Swing is not thread-safe! It causes problems, believe me.
        */
        return null;
    }

    @Override
    protected void done() {
        /* 
         * All code run in this method is done on the EDT, so keep your code here "short and sweet," i.e., not
         * time-consuming.
        */
        if (!isCancelled()) {
            boolean error = false;
            try {
                get(); /* All errors will be thrown by this method, so you definitely need it. If you use the Swing
                        * worker to return a value, it's returned here.
                        * (I never return values from SwingWorkers, so I just use it for error checking).
                        */
            } catch (ExecutionException | InterruptedException e) {
                // Handle your error...
                error = true;
            }
            if (!error) {
                /*
                 * Place your "success" code here, whatever it is.
                */
            }
        }
    }
}