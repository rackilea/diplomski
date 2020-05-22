public class SSO {

    private JDialog dialog;
    private JFXPanel fxPanel;
    private JPanel containerPanel;
    final static String WEBVIEW = "WebView";

    public SSO(){
        // creates Swing components: MUST be called on AWT Event thread
        createPopup();
    }

    private void createPopup(){

        Dimension size = new Dimension(480, 80);

        dialog = new JDialog();
        dialog.setTite("Web Login");

        // make dialog modal:
        dialog.setModalityType(ModalityType.APPLICATION_MODAL);

        // oops: don't want this:
        // dialog.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // but this:
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        containerPanel = new JPanel(new CardLayout());

        fxPanel = new JFXPanel();
        fxPanel.setSize(size);

        Platform.runLater(() -> initJFXPanel(dialog, fxPanel));

        containerPanel.add(fxPanel, WEBVIEW);

        dialog.add(containerPanel, BorderLayout.CENTER);

        dialog.setPreferredSize(size);
        dialog.setResizable(false);
        dialog.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }

    private void initJFXPanel(final JDialog dialog, final JFXPanel fxPanel){

        Group group = new Group();
        Scene scene = new Scene(group);
        fxPanel.setScene(scene);

        WebView webview = new WebView();

        group.getChildren().add(webview);
        webview.setMinSize(500, 640);
        webview.setMaxSize(500, 640);

        CookieManager cookieManager = new CookieManager();
        java.net.CookieHandler.setDefault(cookieManager);

        webview.getEngine().load("http://google.com/");


        if(webview.getEngine().getLocation().equalsIgnoreCase("cookie url")) {
            // harvest the cookies
        }
        else if(webview.getEngine().getLocation().equalsIgnoreCase("end url")) {
            // this will hide the dialog and release the event dispatch thread
            // that is waiting for it, but it must be called on the event dispatch thread
            // not sure of your exact requirements, but you may need to do this
            // in the if clause as well?
            SwingUtilities.invokeLater(() -> dialog.setVisible(false));
        }

    }

}