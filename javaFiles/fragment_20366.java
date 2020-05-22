Action leftAction = new AbstractAction(){
    public void actionPerformed(ActionEvent e){
        // do something when left button pressed;
    }
};

InputMap inputMap = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
ActionMap actionMap = panel.getActionMap();

inputMap.put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
actionMap.put("leftAction", leftAction);  <----