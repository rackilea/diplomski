class XandYandZ extends JComponent {

  boolean initializationFinished = false;

  public XandYandZ() {
    // long initialisation..
    initializationFinished = true;
  }

  public void paintComponent(Graphics g) {
    if (!initializationFinished) return;
    // .. paint ..