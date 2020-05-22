// the delegating  action
public static class SimulateButtonAction extends AbstractAction {

    AbstractButton button;

    public SimulateButtonAction(AbstractButton model, String fire) {
        super(fire);
        this.button = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Action delegate = button.getActionMap().get(getName());
        delegate.actionPerformed(new ActionEvent(button, 
                ActionEvent.ACTION_PERFORMED, getName()));
    }

    public String getName() {
        return (String) getValue(Action.NAME);
    }

}

// example usage
JComponent content = new JPanel(new GridLayout(0, 5));
Action log = new AbstractAction() {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("triggered: " + ((AbstractButton) e.getSource()).getText());
    }

};
String pressed = "pressed";
String released = "released";
ActionMap actionMap = content.getActionMap();
InputMap inputMap = content.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
String[] arrows = {"UP", "DOWN", "LEFT", "RIGHT"};
for (int i = 0; i < arrows.length; i++) {
    JButton button = new JButton(log);
    button.setAction(log);
    button.setText(arrows[i]);
    content.add(button);
    // simulate pressed
    String pressedKey = pressed + arrows[i];
    inputMap.put(KeyStroke.getKeyStroke(arrows[i]), pressedKey);
    actionMap.put(pressedKey, new SimulateButtonAction(button, pressed));
    String releasedKey = released + arrows[i];
    inputMap.put(KeyStroke.getKeyStroke(released + " " +arrows[i]), releasedKey);
    actionMap.put(releasedKey, new SimulateButtonAction(button, released));
}