public class MoveAction extends AbstractAction {
    public MoveAction(String name) {
        putValue(NAME, name);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println(getValue(NAME));
    }
}

//...

MoveAction action = new MoveAction("W");
String ACTION_KEY = "theAction";
KeyStroke W = KeyStroke.getKeyStroke(KeyEvent.VK_W, 0);
InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
inputMap.put(W, ACTION_KEY);
ActionMap actionMap = getActionMap();
actionMap.put(ACTION_KEY, action);

JButton buttonA = new JButton(action);
buttonA.setVisible(false); // This worries me :P