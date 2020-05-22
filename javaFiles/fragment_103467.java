// Get the KeyStroke for our hot key

KeyStroke plus = KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, 0, true);

// Get the input map for our component
// In this case we are interested in key strokes in the focussed window

InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

// Map the key stroke to our "action key" (see below)

inputMap.put(plus, "my_action");

// Get the action map for our component

ActionMap actionMap = panel.getActionMap();

// Add the required action listener to out action map

actionMap.put("my_action", actionListener);