public class CoinHive extends JFrame {

    public CoinHive(PandomiumBrowser browser) {
        super.setSize(1560, 780);
        super.setTitle("CoinHive");
        super.getContentPane().add(browser.toAWTComponent(), BorderLayout.CENTER);
        super.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        PandomiumSettings settings = PandomiumSettings.getDefaultSettings();

        Pandomium pandomium = new Pandomium(settings);
        pandomium.initialize();

        PandomiumClient client = pandomium.createClient();
        PandomiumBrowser browser = client.loadURL("http://c0nw0nk.github.io/CoinHive/");

        SwingUtilities.invokeLater(() -> new CoinHive(browser));
    }

}