int index = tabbedPane.getSelectedIndex();

tabbedPane.setModel(new DefaultSingleSelectionModel() {
    @Override
    public void setSelectedIndex(int index) {
        Component focusOwner =
            FocusManager.getCurrentManager().getFocusOwner();

        if (focusOwner instanceof JComponent) {
            JComponent c = (JComponent) focusOwner;
            InputVerifier verifier = c.getInputVerifier();
            if (verifier != null && !verifier.shouldYieldFocus(c)) {
                return;
            }
        }

        super.setSelectedIndex(index);
    }
});

tabbedPane.setSelectedIndex(index);