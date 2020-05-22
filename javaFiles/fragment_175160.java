JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setBounds(0, 0, 1024, 768);

JDialog paletteWindow = new JDialog(frame, false);
paletteWindow.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
paletteWindow.setResizable(false);
paletteWindow.setFocusableWindowState(false);
paletteWindow.setBounds(1024, 0, 320, 768);

JTable grid = new JTable(new DefaultTableModel(new String[] {"Name", "Value"}, 5)) {
    private KeyEventDispatcher dispatcher;

    @Override
    public Component getEditorComponent() {
        final Component c = super.getEditorComponent();
        if (dispatcher == null) {
            dispatcher = new KeyEventDispatcher() {
                public boolean dispatchKeyEvent(KeyEvent e) {
                    e.setSource(c);
                    for (KeyListener keyListener : c.getKeyListeners()) {
                        if (e.getID() == KeyEvent.KEY_PRESSED) {
                            keyListener.keyPressed(e);
                        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
                            keyListener.keyReleased(e);
                        } else if (e.getID() == KeyEvent.KEY_TYPED) {
                            keyListener.keyTyped(e);
                        }
                    }
                    return false;
                }
            };
            KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(dispatcher);
        }
        return c;
    }

    @Override
    public void removeEditor() {
        if (dispatcher != null) {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(dispatcher);
            dispatcher = null;
        }
        super.removeEditor();
    }
};
paletteWindow.getContentPane().add(new JScrollPane(grid));

frame.setVisible(true);
paletteWindow.setVisible(true);