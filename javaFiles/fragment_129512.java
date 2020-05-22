table.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        ...
        this.firePropertyChange("client", null, i);
    }
}