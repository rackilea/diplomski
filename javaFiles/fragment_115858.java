public class PreviousFocusHandler extends AbstractAction {
    public void actionPerformed(ActionEvent evt) {
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.focusPreviousComponent();
    }
}

public class NextFocusHandler extends AbstractAction {
    public void actionPerformed(ActionEvent evt) {
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.focusNextComponent();
    }
}