public class FXVKAlwaysOn extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 1280, 600);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        Node first = scene.getRoot().getChildrenUnmodifiable().get(0);
        if (first != null) {
            FXVK.init(first);
            FXVK.attach(first);
            getPopupWindow();
        }
    }

    private PopupWindow getPopupWindow() {

        @SuppressWarnings("deprecation") 
        final Iterator<Window> windows = Window.impl_getWindows();

        while (windows.hasNext()) {
            final Window window = windows.next();
            if (window instanceof PopupWindow) {
                if (window.getScene() != null && window.getScene().getRoot() != null) { 
                    Parent root = window.getScene().getRoot();
                    if (root.getChildrenUnmodifiable().size() > 0) {
                        Node popup = root.getChildrenUnmodifiable().get(0);
                        if (popup.lookup(".fxvk") != null) {
                            FXVK vk = (FXVK) popup.lookup(".fxvk");
                            // hide the key:
                            vk.lookup(".hide").setVisible(false);
                            return (PopupWindow) window;
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }
}