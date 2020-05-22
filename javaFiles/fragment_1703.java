import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

/*
 * The ActionMapAction class is a convenience class that allows you to use an installed Action as an
 * Action or ActionListener on a separate component.
 *
 * It can be used on components like JButton or JMenuItem that support an Action as a property of
 * the component. Or it can be added to the same above components as an ActionListener.
 *
 * The benefit of this class is that a new ActionEvent will be created such that the source of the
 * event is the component the Action belongs to, not the component that was "clicked". Otherwise in
 * many cases a ClassCastException will be thrown when the Action is invoked.
 */
@SuppressWarnings("serial")
public class ActionMapAction extends AbstractAction {
  /**
   * @param parent
   * @param popupMenu
   */
  public static void addCopyAndSelectAll(JComponent parent, JPopupMenu popupMenu) {
    // Must use ActionMapAction to link between the MenuItem and Table
    // The "copy" action, for example must be called from a Table, not from MenuItem
    Action copyAction = new ActionMapAction("Copy", parent, "copy");

    JMenuItem copyItem = new JMenuItem(copyAction);
    int MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
    copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, MASK));
    popupMenu.add(copyItem);

    Action selAction = new ActionMapAction(UiMessages.INSTANCE.get("Select All", parent, "selectAll");

    JMenuItem selItem = new JMenuItem(selAction);
    selItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, MASK));
    popupMenu.add(selItem);

    parent.setComponentPopupMenu(popupMenu);
  }

  private Action originalAction;
  private JComponent component;

  private String actionCommand = "";

  /**
   * Replace the default Action for the given KeyStroke with a custom Action
   *
   * @param name the name parameter of the Action
   * @param componet the component the Action belongs to
   * @param actionKey the key to identify the Action in the ActionMap
   */
  public ActionMapAction(String name, JComponent component, String actionKey) {
    super(name);

    originalAction = component.getActionMap().get(actionKey);

    if (originalAction == null) {
      String message = "no Action for action key: " + actionKey;
      throw new IllegalArgumentException(message);
    }

    this.component = component;
  }

  /**
   * Invoke the original Action using the original component as the source of the event.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    e = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, actionCommand, e.getWhen(), e.getModifiers());

    originalAction.actionPerformed(e);
  }

  public void setActionCommand(String actionCommand) {
    this.actionCommand = actionCommand;
  }
}