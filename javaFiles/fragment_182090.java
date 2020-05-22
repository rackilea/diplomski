public class JavaFXDemo {

    private static void initAndShowGUI() {
        JFrame frame = new JFrame("HTML Editor");
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                final HTMLEditor htmlEditor = new HTMLEditor();
                Scene scene = new Scene(htmlEditor);
                fxPanel.setScene(scene);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowGUI();
            }
        });
    }
}