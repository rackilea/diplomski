public void executeTask() {
    progress = new UIProgress();
    progress.prepareGUI();

    final SwingWorker<Void, Void> myWorker = new SwingWorker<Void, Void>() {
        @Override
        protected Void doInBackground() throws Exception {
            // progress.updateProgress (10);
            setProgress(10); // sets the worker's "bound" progress property
            getWorkedItems();

            setProgress(30);
            getWorkedTickets();

            setProgress(50);
            getRemainTickets();

            setProgress(70);

            // ... only further background work goes here
            // no direct Swing calls
            return null;
        }
    };
    myWorker.addPropertyChangeListener(new PropertyChangeListener() {

        @Override
        public void propertyChange(PropertyChangeEvent evt) {

            if ("progress".equals(evt.getPropertyName())) {
                // if the progress property has been changed
                // get its value and use it to update the GUI
                progress.updateProgress((int) evt.getNewValue());
            } else if (SwingWorker.StateValue.DONE == evt.getNewValue()) {
                // worker is done then here notify the GUI
                // perhaps call:
                // jf.postTriagedTicketDetailsDaily();

                // call get() on worker to catch and handle exceptions
                try {
                    myWorker.get();
                } catch (InterruptedException | ExecutionException e) {
                    // TODO handle the excpetions here
                    e.printStackTrace();
                }
            }
        }
    });
    myWorker.execute();
}