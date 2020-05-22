// Note the upped case "Void"s
SwingWorker worker = new SwingWorker<Void, Void>() {
    @Override
    public Void doInBackground() {
        // Do the printing task here
        return null;
    }

    @Override
    public void done() {
        // Update the UI to show the task is completed
    }
}.execute();