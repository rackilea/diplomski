jDateChooser.addPropertyChangeListener(new PropertyChangeListener() {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("date")) {
            stopCellEditing();
        }
    }
});