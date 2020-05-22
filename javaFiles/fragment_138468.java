public void mouseReleased(MouseEvent e) {
    if (SwingUtilities.isLeftMouseButton(e)) {
        // Support for multiClickThreshhold
        if (shouldDiscardRelease) {
            shouldDiscardRelease = false;
            return;
        }
        AbstractButton b = (AbstractButton) e.getSource();
        ButtonModel model = b.getModel();
        model.setPressed(false);
        model.setArmed(false);
    }
}