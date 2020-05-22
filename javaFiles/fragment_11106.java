import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class Main {
  public static void main(String[] argv) {
    KeyboardFocusManager.getCurrentKeyboardFocusManager().addVetoableChangeListener(
        new FocusVetoableChangeListener());
  }
}

class FocusVetoableChangeListener implements VetoableChangeListener {
  public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
    Component oldComp = (Component) evt.getOldValue();
    Component newComp = (Component) evt.getNewValue();

    if ("focusOwner".equals(evt.getPropertyName())) {
      if (oldComp == null) {
        System.out.println(newComp.getName());
      } else {
        System.out.println(oldComp.getName());
      }
    } else if ("focusedWindow".equals(evt.getPropertyName())) {
      if (oldComp == null) {
        System.out.println(newComp.getName());
      } else {
        System.out.println(oldComp.getName());
      }
    }

    boolean vetoFocusChange = false;
    if (vetoFocusChange) {
      throw new PropertyVetoException("message", evt);
    }
  }
}