f.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK),
             "Undo");
f.getRootPane().getActionMap()
        .put("Undo", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("undo");
    }
});