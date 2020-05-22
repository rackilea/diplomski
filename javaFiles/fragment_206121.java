InputMap inMap = functionPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
inMap.put(KeyStroke.getKeyStroke("C"),"Clear");

ActionMap actMap = functionPanel.getActionMap();
actMap.put("Clear",new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent ev) {
        op1HasValue = op2HasValue = operationHasValue = false;
        op1Str = "";
        op2Str = "";
        operation = "";
        answer = "";
        answerField.setText("");
    }
});