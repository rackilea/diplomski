// Check if the parent component is an option pane.  If so we need to
// force a heavy weight popup in order to have event dispatching work
// correctly.
Component c = owner;
while (c != null) {
    if (c instanceof JComponent) {
        if (((JComponent)c).getClientProperty(
                    PopupFactory_FORCE_HEAVYWEIGHT_POPUP) == Boolean.TRUE) {
            popupType = HEAVY_WEIGHT_POPUP;
            break;
        }
    }
    c = c.getParent();
}