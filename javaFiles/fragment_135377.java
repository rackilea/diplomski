import java.awt.*;
import java.awt.event.*;

public class FullTray {

    private static class ShowMessageListener implements ActionListener {

        private TrayIcon trayIcon;
        private String title;
        private String message;
        private TrayIcon.MessageType messageType;

        ShowMessageListener(TrayIcon trayIcon, String title, String message, TrayIcon.MessageType messageType) {
            this.trayIcon = trayIcon;
            this.title = title;
            this.message = message;
            this.messageType = messageType;
        }

        public void actionPerformed(ActionEvent e) {
            trayIcon.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    System.out.println("Message Clicked");
                }
            });
            trayIcon.displayMessage(title, message, messageType);
        }
    }

    public static void main(String args[]) {
        Runnable runner = new Runnable() {

            public void run() {
                if (SystemTray.isSupported()) {
                    final SystemTray tray = SystemTray.getSystemTray();
                    Image image = Toolkit.getDefaultToolkit().getImage("gifIcon.gif");
                    PopupMenu popup = new PopupMenu();
                    final TrayIcon trayIcon = new TrayIcon(image, "The Tip Text", popup);
                    MenuItem item = new MenuItem("Error");
                    item.addActionListener(new ShowMessageListener(trayIcon, "Error Title", "Error", TrayIcon.MessageType.ERROR));
                    popup.add(item);
                    item = new MenuItem("Warning");
                    item.addActionListener(new ShowMessageListener(trayIcon, "Warning Title", "Warning", TrayIcon.MessageType.WARNING));
                    popup.add(item);
                    item = new MenuItem("Info");
                    item.addActionListener(new ShowMessageListener(trayIcon, "Info Title", "Info", TrayIcon.MessageType.INFO));
                    popup.add(item);
                    item = new MenuItem("None");
                    item.addActionListener(new ShowMessageListener(trayIcon, "None Title", "None", TrayIcon.MessageType.NONE));
                    popup.add(item);
                    item = new MenuItem("Close");
                    item.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            tray.remove(trayIcon);
                        }
                    });
                    popup.add(item);
                    try {
                        tray.add(trayIcon);
                    } catch (AWTException e) {
                        System.err.println("Can't add to tray");
                    }
                } else {
                    System.err.println("Tray unavailable");
                }
            }
        };
        EventQueue.invokeLater(runner);
    }

    private FullTray() {
    }
}