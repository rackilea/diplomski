String name = "selectNextRowCell";
Action action = table.getActionMap().get(name);
…
public void actionPerformed(ActionEvent ae) {
    action.actionPerformed(new ActionEvent(table, ActionEvent.ACTION_FIRST, name));
}