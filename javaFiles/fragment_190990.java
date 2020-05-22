if (System.getProperty("os.name").startsWith("Mac OS X")) {
    // only do this setup if we know this is a Mac
    com.apple.eawt.Application macApp = com.apple.eawt.Application.getApplication();
    java.awt.PopupMenu menu = new java.awt.PopupMenu();
    // create your java.awt.MenuItem objects here
    // add to menu via java.awt.Menu#add(java.awt.MenuItem)
    macApp.setDockMenu(menu);
}