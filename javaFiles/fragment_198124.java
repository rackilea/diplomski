int MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
JTextField jtf = new JTextField("Test");
jtf.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, MASK), "select-all");
jtf.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_C, MASK), "copy");
jtf.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_X, MASK), "cut");
jtf.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, MASK), "paste");