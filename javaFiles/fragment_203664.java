protected void fireActionPerformed() {
    ActionListener[] listeners = listenerList.getListeners(ActionListener.class);
    if (listeners != null) {
        ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Awesome button action");
        for (ActionListener listener : listeners) {
            listener.actionPerformed(evt);
        }
    } 
}