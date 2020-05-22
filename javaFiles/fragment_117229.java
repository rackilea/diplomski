JTabbedPane jTabbedPane = new JTabbedPane();
KeyStroke ctrlTab = KeyStroke.getKeyStroke("ctrl PAGE_DOWN");
KeyStroke ctrlShiftTab = KeyStroke.getKeyStroke("ctrl PAGE_UP");
InputMap inputMap = jTabbedPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
inputMap.put(ctrlTab, "none");
inputMap.put(ctrlShiftTab, "none");