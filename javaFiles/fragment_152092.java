public void TestLoadApplet() {
  AppletClass instance = new AppletClass();

  JPanel panel = new JPanel(); // Creating a empty panel
  instance.LoadApplet(panel);
  assertEquals("java.awt.BorderLayout", panel.getLayout().getClass().getName());
  assertEquals("Applets.AppletClassName", panel.getComponent().getClass().getName());
  }