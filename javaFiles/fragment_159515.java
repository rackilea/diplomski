public static void main (String [] args) {
    if (!SystemTray.isSupported()) {
        System.out.println("SystemTray is not supported");
        return;
    }
    Image image = Toolkit.getDefaultToolkit().getImage("MY/PATH/TO_IMAGE");

    final PopupMenu popup = new PopupMenu();
    final TrayIcon trayIcon = new TrayIcon(image, "MY PROGRAM NAME", popup);
    final SystemTray tray = SystemTray.getSystemTray();

    MenuItem exitItem = new MenuItem("Exit");
    exitItem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.exit(1);
        }
    });
    popup.add(exitItem);

    trayIcon.setPopupMenu(popup);

    try {
        tray.add(trayIcon);
    } catch (AWTException e) {
        System.out.println("TrayIcon could not be added.");
    }
}