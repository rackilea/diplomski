SwingWorker myWorker = new Worker();
myWorker.addPropertyChangeListener(new PropertyChangeListener() {
  @Override
  public void propertyChange(final PropertyChangeEvent event) {
    switch (event.getPropertyName()) {
    case "progress":
      myProgressBar.setIndeterminate(false);
      myProgressBar.setValue((Integer) event.getNewValue());
      break;
    }
 }
});