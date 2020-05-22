Container root = ...
// pressed TAB, control pressed TAB
Set<AWTKeyStroke> defaultKeys = root.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS);
// since defaultKeys is unmodifiable
Set<AWTKeyStroke> newKeys = new HashSet<>(defaultKeys); 
newKeys.add(KeyStroke.getKeyStroke("pressed ENTER"));
root.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, newKeys);