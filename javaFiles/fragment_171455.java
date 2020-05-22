JPopupMenu menu = new JPopupMenu();
menu.add(new JMenuItem("remove"));
JMenuItem addItem = new JMenu("add");
menu.add(addItem);

addItem.add(new JMenuItem("pizza"));
addItem.add(new JMenuItem("cake"));