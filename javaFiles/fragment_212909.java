private class ModelListener implements ChangeListener {
    private boolean pressed = false;

    @Override
    public void stateChanged(ChangeEvent e) {
        boolean modelPressed = ((ButtonModel) e.getSource()).isPressed();
        if (modelPressed != pressed) {
            // if pressed state has changed
            pressed = modelPressed;  // update the state

            // and then do something with it
            System.out.println("Pressed: " + pressed);
        }
    }
}