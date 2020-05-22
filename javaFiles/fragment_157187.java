public boolean close() {

    final Shell grandShell = this.getShell();
    grandShell.setVisible(false);

    Display display = Display.getCurrent();

    Tray tray = display.getSystemTray();
    if(tray != null) {
        TrayItem item = new TrayItem(tray, SWT.NONE);
        item.setImage(ArecaImages.ICO_SMALL);
        final Menu menu = new Menu(getShell(), SWT.POP_UP);
        MenuItem menuItem = new MenuItem(menu, SWT.PUSH);
        menuItem.setText("Areca");
        menuItem.addListener (SWT.Selection, new Listener () {
            public void handleEvent (Event event) {
                grandShell.setVisible(true);
            }
        });
        item.addListener (SWT.MenuDetect, new Listener () {
            public void handleEvent (Event event) {
                menu.setVisible (true);
            }
        });

    }

    return true;