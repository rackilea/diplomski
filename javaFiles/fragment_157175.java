getInputMap(c).put(KeyStroke.getKeyStroke("D"), "pressed");
getActionMap().put("pressed", right);
getInputMap(c).put(KeyStroke.getKeyStroke("released D"), "released");
getActionMap().put("released", stop);
getInputMap(c).put(KeyStroke.getKeyStroke("W"), "pressed");
getActionMap().put("pressed", up); // this overwrites the "pressed" action name above with the up action
getInputMap(c).put(KeyStroke.getKeyStroke("released W"), "released");
getActionMap().put("released", stop); // similarly, this is redundant because you have the same thing above