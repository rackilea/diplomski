public class Button {
  private final List<ActionListener> listeners = new ArrayList<ActionListener>();

  public void addActionListener(ActionListener l) {
    listeners.add(l);
  }

  public void click() {
    ActionEvent event = new ActionEvent(this, 0, "click");
    for (ActionListener l : listeners) {
      l.actionPerformed(event);
    }
  }
}