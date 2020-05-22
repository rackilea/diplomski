public void setListener(ActionListener listener) {
    ActionListener[] listeners = jButton.getActionListeners();
    for(ActionListener l : listeners) {
       jButton.removeActionListener(l); // remove all current ActionListeners
    }
    // set new ActionListener
    jButton.addActionListener(listener);
}