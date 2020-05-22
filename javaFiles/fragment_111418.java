Action actionListener = new AbstractAction() {
  public void actionPerformed(ActionEvent actionEvent) {
    JButton source = (JButton) actionEvent.getSource();
    System.out.println("Activated: " + source.getText());// just for test
  }
};
//.....

KeyStroke controlAlt7 = KeyStroke.getKeyStroke("control alt 7");
InputMap inputMap = button.getInputMap();
inputMap.put(controlAlt7, ACTION_KEY);
ActionMap actionMap = button.getActionMap();
actionMap.put(ACTION_KEY, actionListener);