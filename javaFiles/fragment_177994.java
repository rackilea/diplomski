//parent menu
JPopupMenu pmenu = new JPopupMenu("Menu");

//sub menu
JMenu sectionsMenu = new JMenu("Sections");
JMenuItem menuItem1 = new JMenuItem("Item1");
sectionsMenu .add(menuItem1 );
JMenuItem menuItem2 = new JMenuItem("Item2");
sectionsMenu .add(menuItem2 );

pmenu.add(sectionsMenu);

//regular menu item
menuItem = new JMenuItem("Numbers");
Pmenu.add(menuItem);