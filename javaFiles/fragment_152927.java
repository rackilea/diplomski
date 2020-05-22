import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.net.ConnectException;
import javax.swing.*;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AnotherTest extends JFrame {

    WebDriver driver;
    JLabel label;

    public AnotherTest() {
        super("Test");
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 400) / 2, (screenSize.height - 100) / 2, 400, 100);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent evt) {
                quitApplication();
            }
        });

        JButton jButton1 = new javax.swing.JButton();

        label = new JLabel("");
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(jButton1);

        add(panel, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);


        jButton1.setText("Open Microsoft");

        jButton1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                label.setText("Loading browser. Please wait..");

                java.util.Timer t = new java.util.Timer();
                t.schedule(new java.util.TimerTask() {

                    @Override
                    public void run() {
                        openBrowserAndWait();
                    }
                }, 10);
            }
        });

    }

    private void openBrowserAndWait() {
        driver = new FirefoxDriver();
        String baseUrl = "https://www.microsoft.com";
        driver.get(baseUrl);

        java.util.Timer monitorTimer = new java.util.Timer();
        monitorTimer.schedule(new java.util.TimerTask() {

            @Override
            public void run() {
                while (true) {
                    checkDriver();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }, 10);
    }

    private void checkDriver() {
        if (driver == null) {
            return;
        }

        boolean shouldExit = false;

        try {
            label.setText(driver.getTitle());
        } catch (NoSuchWindowException e) {
            System.out.println("Browser has been closed. Exiting Program");
            shouldExit = true;
        } catch (Exception e) {
            System.out.println("Browser has been closed. Exiting Program");
            shouldExit = true;
        }

        if (shouldExit) {
            this.quitApplication();
        }
    }

    private void quitApplication() {
        // attempt to close gracefully
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
            }
        }

        System.exit(0);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AnotherTest().setVisible(true);
            }
        });
    }
}