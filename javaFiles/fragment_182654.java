// 1. Let's add the initial popup to the text field.
JTextField textField = new JTextField();
JPopupMenu popup = new JPopupMenu();
textField.add(popup);
textField.setComponentPopupMenu(popup);

// 2. Let's create a sub-menu that "expands"
JMenu subMenu = new JMenu("m");
subMenu.add("m1");
subMenu.add("m2");

// 3. Finally, add the sub-menu and item to the popup
popup.add(subMenu);
popup.add("n");