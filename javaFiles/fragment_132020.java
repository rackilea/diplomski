MenuManager contextMenu = new MenuManager();
contextMenu.setRemoveAllWhenShown(true);

Control control = viewer.getControl();
Menu menu = contextMenu.createContextMenu(control);
control.setMenu(menu);

getSite().registerContextMenu(contextMenu, viewer);