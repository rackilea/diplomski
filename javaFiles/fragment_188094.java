InputMap im = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
ActionMap am = getRootPane().getActionMap();

im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancel");
am.put("cancel", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }
});