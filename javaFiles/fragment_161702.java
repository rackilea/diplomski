// Make a basic JOptionPane instance
JOptionPane pane = new JOptionPane(field, 
        JOptionPane.PLAIN_MESSAGE, 
        JOptionPane.OK_CANCEL_OPTION, 
        null);
// Use it's own dialog creation process, it's simpler this way
JDialog dialog = pane.createDialog("Rename");
// When the window is displayed, we want to "steal"
// focus from what the `JOptionPane` has set
// and apply it to our text field
dialog.addWindowListener(new WindowAdapter() {
    @Override
    public void windowActivated(WindowEvent e) {
        // Set a small "delayed" action
        // to occur at some point in the future...
        // This way we can circumvent the JOptionPane's
        // focus control
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                field.requestFocusInWindow();
            }
        });
    }
});
// Put it on the screen...
dialog.setVisible(true);
dialog.dispose();
// Get the resulting action (what button was activated)
Object value = pane.getValue();
if (value instanceof Integer) {
    int result = (int)value;
    // OK was actioned, get the new name
    if (result == JOptionPane.OK_OPTION) {
        String newName = field.getText();
        System.out.println("newName = " + newName);
    }
}