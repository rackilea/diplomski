refreshButton.disableProperty().bind(new BooleanBinding() {

  {
    bind(currentOrder.idOrderProperty());
  }

  @Override protected boolean computeValue() {
    return currentOrder.getIdOrder() != 1;
  }

  @Override public void dispose() {
    // for a proper implementation, we need this as well
    unbind(currentOrder.idOrderProperty());
  }
});