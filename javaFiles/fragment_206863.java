public void mouseEntered(MouseEvent e) {
    AbstractButton b = (AbstractButton) e.getSource();
    ButtonModel model = b.getModel();
    if (b.isRolloverEnabled() && !SwingUtilities.isLeftMouseButton(e)) {
        model.setRollover(true);
    }
    if (model.isPressed())
            model.setArmed(true);
}