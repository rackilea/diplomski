/**
 * Processes any focus events, such as
 * <code>FocusEvent.FOCUS_GAINED</code> or
 * <code>FocusEvent.FOCUS_LOST</code>.
 *
 * @param e the <code>FocusEvent</code>
 * @see FocusEvent
 */
protected void processFocusEvent(FocusEvent e) {
    super.processFocusEvent(e);

// ignore temporary focus event
if (e.isTemporary()) {
    return;
}

    if (isEdited() && e.getID() == FocusEvent.FOCUS_LOST) {
    InputContext ic = getInputContext();
    if (focusLostHandler == null) {
    focusLostHandler = new FocusLostHandler();
    }

    // if there is a composed text, process it first
    if ((ic != null) && composedTextExists) {
    ic.endComposition();
    EventQueue.invokeLater(focusLostHandler);
    } else {
    focusLostHandler.run();
    }
    }
    else if (!isEdited()) {
        // reformat
        setValue(getValue(), true, true);
    }
}