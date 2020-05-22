public class MyClass {
  private JButton kutu = null;

  // in some action listener:
  public void actionPerformed(ActionEvent e) {
    // only create this JButton if the variable has not
    // been assigned a JButton object
    if (kutu == null) {
      kutu = new JButton("Some Text");

      // ... etc
    }
  }