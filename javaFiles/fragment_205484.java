AbstractAction escapeAction = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
         //code here example
         ((JComponent)e.getSource()).setVisible(Boolean.FALSE);
    }};
 String key = "ESCAPE";
 KeyStroke keyStroke = KeyStroke.getKeyStroke(key);
 component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, key);
 component.getActionMap().put(key, escapeAction);