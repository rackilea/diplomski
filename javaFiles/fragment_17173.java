// instruct the JTree not to close the popup
tree.putClientProperty("doNotCancelPopup",
    new JComboBox().getClientProperty("doNotCancelPopup"));

// create the popup menu not inside the listener
JPopupMenu popup = new JPopupMenu();
popup.add(new JMenuItem("menu1"));

// add the listener to the JTree
MouseListener popupListener = new PopupListener(popup);
tree.addMouseListener(popupListener);