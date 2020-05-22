class BrowserTopComponent ... {

  Browswer fff = new Browser();

  BrowserTopComponent() {
    initComponents();
  }

  private void navButtonActionPerformed(ActionEvent evt) {
    fff.navigateTo();
  }

}