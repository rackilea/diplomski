try {
    MyWorker worker = new MyWorker(new URL("http://localhost"), file);
    worker.addPropertyChangeListener(new PropertyChangeListener() {

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals("progress")) {
                Integer progress = (Integer) evt.getNewValue();
                progressBar.setValue(progress);
            }
        }
    });
    worker.execute();
} catch (MalformedURLException ex) {
    ex.printStackTrace();
}