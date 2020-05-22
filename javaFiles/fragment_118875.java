editor.onKeyReleasedProperty().addListener(new ChangeListener<EventHandler<? super KeyEvent>> () {
  @Override
  public void changed(ObservableValue<? extends EventHandler<? super KeyEvent>> observable, EventHandler<? super KeyEvent> oldValue, EventHandler<? super KeyEvent> newValue) {
    System.out.println("changed!");
  }
});