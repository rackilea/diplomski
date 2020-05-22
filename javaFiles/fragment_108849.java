public class Demo extends Application{
    private static JFXPanel javafxPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowGUI();
            }
        });
    }

    public static void initAndShowGUI() {
        JFrame frame = new JFrame("Swing application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JavaFX panel.
        javafxPanel = new JFXPanel();
        frame.getContentPane().add(javafxPanel, BorderLayout.CENTER);

        // Create JavaFX scene.
        Application.launch (Demo.class, null);

        // Show frame.
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void start (Stage mainStage) {
        // Add scene to panel
        javafxPanel.setScene(createScene());
    }

    private static Scene createScene() {
        Text text = new Text("Hello World");
        text.setFont(new Font(24));
        text.setEffect(new Reflection());

        BorderPane pane = new BorderPane();
        pane.setCenter(text);
        Scene scene = new Scene(pane);

        return scene;
    }
}