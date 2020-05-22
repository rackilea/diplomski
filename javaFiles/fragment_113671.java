Action rightAction = new AbstractAction(){
        public void actionPerformed(ActionEvent e) {
            x +=10;
            drawPanel.repaint();
        }
    };

    InputMap inputMap = drawPanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
    ActionMap actionMap = drawPanel.getActionMap();

    inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
    actionMap.put("rightAction", rightAction);