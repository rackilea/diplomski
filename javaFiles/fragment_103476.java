public class JavaFxApp extends Application implements Observe{

    private static final CountDownLatch latch = new CountDownLatch(1);
    private static Observe observer = null;
    private Label label;

   @Override public void init() {
       observer = this;
       latch.countDown();
    }

    @Override public void start(Stage stage){
        label = new Label("waiting");
        BorderPane pane = new BorderPane(label);
        Scene scene = new Scene(pane, 100, 100);
        stage.setScene(scene);
        stage.show();
    }

    @Override public void update(int i) {
        Platform.runLater(()-> label.setText(String.valueOf(i)));
    }

    static Observe getObserver() {
        try {
            latch.await();
        } catch (InterruptedException e) { e.printStackTrace();  }

        return observer;
    }
}