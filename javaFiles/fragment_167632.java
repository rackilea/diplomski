// imports omitted

public class MyImageUpdatingApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Main application");
        BorderPane root = new BorderPane(label);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        startImageUpdateThread();
    }

    private void startImageUpdateThread() {
        ImageView imageView = new ImageView();
        BorderPane root = new BorderPane(imageView);
        Scene scene = new Scene(root, 600, 400);
        Stage imageViewWindow = new Stage()
        imageViewWindow.setScene(scene);
        imageViewWindow.show();
        final int pause = 50 ;
        Thread t = new Thread( () -> {
            while (moreImagesToGet()) {
                Image image = getNextImage() ;
                Platform.runLater( () -> imageView.setImage(image) );
                try {
                    Thread.sleep(pause);
                } catch (Exception exc) {
                    exc.printStackTrace();
                    break();
                }
            }
        });
        t.setDaemon(true); // this thread won't prevent application exit
        t.setName("Image update thread");
        t.start();
    }

    // ...
}