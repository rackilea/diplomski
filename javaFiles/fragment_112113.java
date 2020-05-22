public class TrayMessageActionListener implements ActionListener {
    private TrayIcon trayIcon;

    public TrayMessageActionListener(TrayIcon trayIcon) {
        this.trayIcon = trayIcon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        trayIcon.displayMessage("Title", "Message", TrayIcon.MessageType.ERROR);
    }

}