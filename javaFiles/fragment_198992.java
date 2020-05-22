JPanel panel = new JPanel();
InputMap im = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
im.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK), "printAction");
ActionMap am = panel.getActionMap();
am.put("printAction", printHelloAction);    // add to JPanel ActionMap

JButton button = new JButton(printHelloAction); // add to JButton
button.setText("Print Hello");