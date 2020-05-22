JMenuBar menuBar = new JMenuBar();
    JMenuItem saveItem, saveAllItem;

    // Menu
    JMenu fileMenu = new JMenu("File");

    // Menu Item (Drop down menus)
    saveItem = new JMenuItem("Save");
    saveAllItem = new JMenuItem("Save All");

    // Adding menu items to menu
    fileMenu.add(saveItem);
    fileMenu.add(saveAllItem);

    // adding menu to menu bar
    menuBar.add(fileMenu);

    // setting menubar at top of the window.

    // if you create a object of JFrame in class then code to set JMenuBar to JFrame will be:
    // jframe.setJMenuBar(menuBar);
    // if class is extending JFrame then it will be like this:
    setJMenuBar(menuBar);