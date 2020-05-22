Component c = event.getComponent();
Window window = SwingUtilities.windowForComponent(c);
JDialog dialog = new JDialog(...);
...
dialog.pack();
dialog.setLocation( window.getLocation() );
dialog.setVisible( rue ;