public void stateChanged(ChangeEvent e) {
    Object source = e.getSource();

    updateMnemonicProperties();
    if (isEnabled() != model.isEnabled()) {
        setEnabled(model.isEnabled());
    }
    fireStateChanged();
    repaint();
}