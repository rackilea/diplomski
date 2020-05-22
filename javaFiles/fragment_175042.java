public class MyMenuUI extends SynthMenuUI {


  public static ComponentUI createUI(JComponent aComponent) {
    return new MyMenuUI();
  }

  @Override
  public void installUI(JComponent c) {
    super.installUI(c);
    c.setForeground(UIManager.getColor("Menu.foreground"));
  }
}