Action pressedAction = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        spaceBarPressed = true;
    }
};

Action releasedAction = new AbstractAction() {
    public void actionPerformed(ActionEvent e) {
        spaceBarPressed = false;
    }
};

oneOfYourComponents.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "pressed");
oneOfYourComponents.getInputMap().put(KeyStroke.getKeyStroke("released SPACE"), "released");
oneOfYourComponents.getActionMap().put("pressed", pressedAction);
oneOfYourComponents.getActionMap().put("released", releasedAction);