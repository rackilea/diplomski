public class TestTrayIcon01 {

    public static void main(String[] args) {
        new TestTrayIcon01();
    }

    public TestTrayIcon01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    TrayIcon icon = new TrayIcon(ImageIO.read(getClass().getResource("/SmallTeddy.png")));
                    SystemTray tray = SystemTray.getSystemTray();
                    tray.add(icon);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                JDialog dialog = new JDialog();
                dialog.setSize(100, 100);
                dialog.setVisible(true);
            }
        });
    }

}