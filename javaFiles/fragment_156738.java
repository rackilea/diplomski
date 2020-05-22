// Password
createLabel(g, CVSUIMessages.ConfigurationWizardMainPage_password);
passwordText = createPasswordField(g);
passwordText.addListener(SWT.Modify, listener);

Listener listener = new Listener() {
  public void handleEvent(Event event) {
    if (event.widget == passwordText) {
       // check its length