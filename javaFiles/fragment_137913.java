InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
ActionMap am = getActionMap();

im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "Press.A");
am.put("Press.A", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        gameConsole.append("\n\nCommands: \n ==========");
        commands();
    }
});