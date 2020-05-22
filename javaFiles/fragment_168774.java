JComboBox formation = new JComboBox();
//...
formation.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        fireFormationChanged();
    }
});

//...

protected void fireFormationChanged() {
    // changeListeners is a simple List of ChangeListener
    // this is instance of FantasyView
    ChangeEvent evt = new ChangeEvent(this);
    for (ChangeListener listener : changeListeners) {
        listener.stateChanged(evt);
    }
}