new SwingWorker<Void, Void>() {
    @Override
    protected Void doInBackground() throws Exception {
        strum();
        return null;
    }

    @Override
    protected void done() {
        //do something to clean up or so
    }
}.execute();