SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {
    @Override
    protected String doInBackground() throws InterruptedException {
        Thread.sleep(5000);
        return "hello";
    }

    @Override
    protected void done() {
        loading.dispose();
    }
};
worker.addPropertyChangeListener(new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt.getPropertyName());
        Object value = evt.getNewValue();
        if (value instanceof SwingWorker.StateValue) {
            SwingWorker.StateValue state = (SwingWorker.StateValue) value;
            switch (state) {
                case DONE: {
                    try {
                        String result = worker.get();
                        JOptionPane.showMessageDialog(null, result);
                    } catch (InterruptedException | ExecutionException ex) {
                        ex.printStackTrace();
                    }
                }
                break;
            }
        }
    }
});
worker.execute();
loading.setVisible(true);