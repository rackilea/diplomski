final FileLoader loader = new FileLoader(filePath);

  loader.addPropertyChangeListener(new PropertyChangeListener() {
     @Override
     public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
           // since DONE is enum, no need for equals(...) method
           if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
              try {
                 loader.get();
              } catch (InterruptedException e) {
                 e.printStackTrace();
              } catch (ExecutionException e) {
                 e.printStackTrace();
              }
           }
        }
     }
  });

  new ProgressWindow(loader, "Loading File", "Loading File");