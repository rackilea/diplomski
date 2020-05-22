/**
 * Support for reporting bound property changes for Object properties. 
 * This method can be called when a bound property has changed and it will
 * send the appropriate PropertyChangeEvent to any registered
 * PropertyChangeListeners.
 *
 * @param propertyName the property whose value has changed
 * @param oldValue the property's previous value
 * @param newValue the property's new value
 */
protected void firePropertyChange(String propertyName,
                                  Object oldValue, Object newValue) {
    PropertyChangeSupport changeSupport;
    synchronized (getObjectLock()) {
        changeSupport = this.changeSupport;
    }
    if (changeSupport == null ||
        (oldValue != null && newValue != null && oldValue.equals(newValue))) {
        return;
    }
    changeSupport.firePropertyChange(propertyName, oldValue, newValue);
}