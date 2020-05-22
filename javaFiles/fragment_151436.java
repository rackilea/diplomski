Go_Shadow.getModel().addChangeListener(new ChangeListener() {
    @Override
    public void stateChanged(ChangeEvent e) {
        ButtonModel model = (ButtonModel) e.getSource();
        JFrame window = (JFrame) SwingUtilities.getWindowAncestor(TextFrame.this);
        if (model.isArmed() && model.isPressed()) {
            window.setUndecorated(true);
            window.setOpacity(0.5f);
            setOpaque(false);
        } else if (model.isArmed() && !model.isPressed()) {
            setOpaque(true);
            window.setOpacity(1f);
            window.setUndecorated(false);
        }
    }
});