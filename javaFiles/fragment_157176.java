getInputMap(c).put(KeyStroke.getKeyStroke("D"), "right");
getInputMap(c).put(KeyStroke.getKeyStroke("released D"), "stop");
getInputMap(c).put(KeyStroke.getKeyStroke("W"), "up");
getInputMap(c).put(KeyStroke.getKeyStroke("released W"), "stop");
getActionMap().put("right", right);
getActionMap().put("up", up);
getActionMap().put("stop", stop);