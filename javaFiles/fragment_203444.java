MenuManager contextMenu = new MenuManager();

contextMenu.setRemoveAllWhenShown(true);

getSite().registerContextMenu(contextMenu, viewer);

Control control = viewer.getControl();
Menu menu = contextMenu.createContextMenu(control);
control.setMenu(menu);