InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up");
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");

ActionMap am = getActionMap();
am.put("up", new MoveAction(0, -1));
am.put("down", new MoveAction(0, 1));
am.put("left", new MoveAction(-1, 0));
am.put("right", new MoveAction(1, 0));