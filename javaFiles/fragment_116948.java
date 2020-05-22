button.addKeyPressHandler(new KeyPressHandler() {
  public void onKeyPress(KeyPressEvent event) {
    TextBox b = (TextBox)event.getSource();
    if (!b.getValue().startsWith("$")) {
      b.setValue("$" + b.getValue());
    }
  }
});