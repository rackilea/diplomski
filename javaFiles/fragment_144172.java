public static void showMenu(Image trayImage, String... items) {

    if (!java.awt.SystemTray.isSupported())
        throw new UnsupportedOperationException("No system tray support, application exiting.");

    java.awt.Toolkit.getDefaultToolkit();

    java.awt.SystemTray tray = java.awt.SystemTray.getSystemTray();
    java.awt.TrayIcon trayIcon = new java.awt.TrayIcon(trayImage);
    java.awt.PopupMenu rootMenu = new java.awt.PopupMenu();

    for (String item : items) rootMenu.add(new MenuItem(item));

    trayIcon.setPopupMenu(rootMenu);

    try {
        tray.add(trayIcon);
    } catch (Throwable e) {
        throw new RuntimeException("Unable to init system tray");
    }
}