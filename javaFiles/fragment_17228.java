//...where initialization occurs:
...
amountField.addPropertyChangeListener("childUpdated",
                                      new ChildUpdateListener());
...
class ChildUpdateListener implements PropertyChangeListener {
    public void propertyChanged(PropertyChangeEvent e) {
        updateToPreferedSize();
    }
}