KeyStroke homeKey = KeyStroke.getKeyStroke("HOME");
InputMap inputMap = editor.getInputMap(JComponent.WHEN_FOCUSED);
ActionMap actionMap = editor.getActionMap();
Action action = actionMap.get("caret-begin-line");
inputMap.put(homeKey, "caret-begin-line"); 
actionMap.put("caret-begin-line", new HomeCommand(action));