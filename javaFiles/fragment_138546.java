// 1. Get default keys
Set<AWTKeyStroke> ftk = new HashSet<AWTKeyStroke>(
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
        .getDefaultFocusTraversalKeys(
        KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));

// 2. Add our key
ftk.add(KeyStroke.getKeyStroke("ENTER"));

// 3. Set new keys
KeyboardFocusManager.getCurrentKeyboardFocusManager()
        .setDefaultFocusTraversalKeys(
        KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, ftk);