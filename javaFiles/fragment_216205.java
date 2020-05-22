private static final String solve = "Solve";
KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, solve);
table.getActionMap().put(solve, new EnterAction());
...
private class EnterAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        ...
    }
}