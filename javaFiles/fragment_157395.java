// the applet will typically appear inside a Window, get a reference to it using:
Window parent = Window.getWindows()[0];
// use the window as the parent of a modal dialog.
JDialog dialog = new JDialog(parent);
dialog.setModal(true);
// ...
dialog.setVisible(true);
// won't be called until the applet is dismissed 
someJComponent.requestFocusInWindow();