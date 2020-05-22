import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SystemTrayExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new SystemTrayExample().createAndAddTrayIcon();
            }
        });
    }

    private void createAndAddTrayIcon() {
        try {
            initComponents();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }

    private void initComponents() throws MalformedURLException {

        //Check the SystemTray is supported
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().createImage(new URL("http://docs.oracle.com/javase/tutorial/uiswing/examples/misc/TrayIconDemoProject/src/misc/images/bulb.gif")));
        trayIcon.setToolTip("I am the initial message");

        final SystemTray tray = SystemTray.getSystemTray();

        // Create a pop-up menu components
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Add components to pop-up menu
        popup.add(exitItem);

        //set popmenu
        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }

        int delay = 5000; //milliseconds
        final Timer timer = new Timer(delay, new ActionListener() {

            int count = 1;

            @Override
            public void actionPerformed(ActionEvent evt) {

                System.out.println("Updating on EDT " + (SwingUtilities.isEventDispatchThread() ? "Yes" : "No"));

                if (count == 3) {
                    trayIcon.setToolTip("I am the last message");
                    ((Timer) evt.getSource()).stop();//stop timer
                }
                if (count == 2) {//check if we should change tooltip
                    trayIcon.setToolTip("I am the second message");
                }
                if (count == 1) {
                    trayIcon.setToolTip("I am the  first message");
                }

                count++;

            }
        });

        timer.start();//start timer to change tooltip
    }
}