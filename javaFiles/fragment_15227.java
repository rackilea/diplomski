public class ProgressWorker extends SwingWorker<Void, Integer> {

    private int delay;
    private JProgressBar pb;

    public ProgressWorker(JProgressBar progressBar, int delay) {
        this.pb = progressBar;
        this.delay = delay;
        // You can use a property change listener to monitor progress updates...
        addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
                    pb.setValue((Integer)evt.getNewValue());
                }
            }

        });
    }

    @Override
    protected Void doInBackground() throws Exception {
        for (int index = 0; index < 100; index++) {
            setProgress(index);
            Thread.sleep(delay);
        }
        return null;
    }

    @Override
    protected void done() {
        // Back in the EDT...
        //pii.dispose();
        //o.Eros();
    }

}