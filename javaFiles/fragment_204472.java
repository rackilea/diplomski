task.valueProperty().addListener(new ChangeListener<Task>() {
  @Override
  public void changed(ObservableValue<? extends mytype> obs, mytype oldValue, mytype newValue) {
    if (newValue != null) {
      System.out.println("Result of task "+newValue);
    }
  }
});