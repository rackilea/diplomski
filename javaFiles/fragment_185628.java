private void clickArrowButton(String actionKey) {
    ActionMap map = getActionMap();
    if (map != null) {
        Action action = map.get(actionKey);
        if (action != null && action.isEnabled()) {
            action.actionPerformed(new ActionEvent(
                    this, ActionEvent.ACTION_PERFORMED, null, 0, 0));
        }
    }
}