void invokeAsSoonAsPossible(Runnable action) {
    if (SwingUtilities.isEventDispatchThread())
        action.run();
    else SwingUtilities.invokeLater(action);
}

// Usage:
invokeAsSoonAsPossible(new Runnable(){
    @Override
    public void run() {
        jTable.getModel().setValueAt(...
    }
});