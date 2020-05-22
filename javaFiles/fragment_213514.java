SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
    @Override
    protected Void doInBackground() {
        //do your stuff in background
        return null;
    }

    @Override
    protected void done() {
        frmMain.setVisible(true);
        loading.dispose();
        disposeThis(); //a method that calls this.dispose();
    }
};
worker.execute();
loading.setVisible(true);