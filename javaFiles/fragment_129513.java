table.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        ...
        SelectTableFollowup.this.firePropertyChange("client", null, i);
    }
}