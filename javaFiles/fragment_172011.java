public static class VetoableSingleSelectionModel extends
        DefaultSingleSelectionModel {

    private VetoableChangeSupport vetoableChangeSupport;

    @Override
    public void setSelectedIndex(int index) {
        if (getSelectedIndex() == index)
            return;
        try {
            fireVetoableChange(getSelectedIndex(), index);
        } catch (PropertyVetoException e) {
            return;
        }
        super.setSelectedIndex(index);
    }

    private void fireVetoableChange(int oldSelectionIndex,
            int newSelectionIndex) throws PropertyVetoException {
        if (!isVetoable())
            return;
        vetoableChangeSupport.fireVetoableChange("selectedIndex",
                oldSelectionIndex, newSelectionIndex);

    }

    private boolean isVetoable() {
        if (vetoableChangeSupport == null)
            return false;
        return vetoableChangeSupport.hasListeners(null);
    }

    public void addVetoableChangeListener(VetoableChangeListener l) {
        if (vetoableChangeSupport == null) {
            vetoableChangeSupport = new VetoableChangeSupport(this);
        }
        vetoableChangeSupport.addVetoableChangeListener(l);
    }

    public void removeVetoableChangeListener(VetoableChangeListener l) {
        if (vetoableChangeSupport == null)
            return;
        vetoableChangeSupport.removeVetoableChangeListener(l);
    }

}

// usage
JTabbedPane pane = new JTabbedPane();
VetoableSingleSelectionModel model = new VetoableSingleSelectionModel();
VetoableChangeListener validator = new VetoableChangeListener() {

    @Override
    public void vetoableChange(PropertyChangeEvent evt)
            throws PropertyVetoException {
        int oldSelection = (int) evt.getOldValue();
        if ((oldSelection == -1) || isValidTab(oldSelection)) return;

        throw new PropertyVetoException("change not valid", evt);

    }

    private boolean isValidTab(int oldSelection) {
        // implement your validation logic here
        return false;
    }
};
model.addVetoableChangeListener(validator);
pane.setModel(model);
pane.addTab("one", new JLabel("here we are and stay"));
pane.addTab("other", new JLabel("poor me, never shown"));