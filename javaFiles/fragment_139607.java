SwingWorker worker = new MyWorker();
    worker.addPropertyChangeListener(new MyProgressListener());
    worker.execute();

   class MyProgressListener implements PropertyChangeListener {
      @Override
      public void propertyChange(final PropertyChangeEvent event) {
        if(event.getPropertyName().equalsIgnoreCase("progress")) {
          downloadProgressBar.setIndeterminate(false);
          downloadProgressBar.setValue((Integer) event.getNewValue());
        }         
      }
     }