private void setKeyBindings() {
    InputMap inputMap = 
            gridPanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
    inputMap.put(KeyStroke.getKeyStroke("W"), "up arrow");
    inputMap.put(KeyStroke.getKeyStroke("S"), "down arrow");
    inputMap.put(KeyStroke.getKeyStroke("A"), "left arrow");
    inputMap.put(KeyStroke.getKeyStroke("D"), "right arrow");

    inputMap.put(KeyStroke.getKeyStroke("UP"), "up arrow");
    inputMap.put(KeyStroke.getKeyStroke("DOWN"), "down arrow");
    inputMap.put(KeyStroke.getKeyStroke("LEFT"), "left arrow");
    inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "right arrow");

    inputMap = gridPanel.getInputMap(JPanel.WHEN_FOCUSED);
    inputMap.put(KeyStroke.getKeyStroke("UP"), "up arrow");
    inputMap.put(KeyStroke.getKeyStroke("DOWN"), "down arrow");
    inputMap.put(KeyStroke.getKeyStroke("LEFT"), "left arrow");
    inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "right arrow");


    gridPanel.getActionMap().put("up arrow", 
            new UpArrowAction(this, model));
    gridPanel.getActionMap().put("down arrow", 
            new DownArrowAction(this, model));
    gridPanel.getActionMap().put("left arrow", 
            new LeftArrowAction(this, model));
    gridPanel.getActionMap().put("right arrow", 
            new RightArrowAction(this, model));
}