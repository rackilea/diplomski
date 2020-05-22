EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {

        Image img = null;
        try {
            img = ImageIO.read(new File("..."));
        } catch (IOException e) {
            e.printStackTrace();
        }
        TrayIcon ti = new TrayIcon(img, "Tooltip");
        try {
            // You need to add it to the system tray first
            SystemTray.getSystemTray().add(ti);
        } catch (AWTException ex) {
          ex.printStackTrace();
        }
        ti.displayMessage("Low Disk Space", "Diskspace is very low",
                MessageType.WARNING);

    }

});