public class MainFrame extends Application {

    public static void main(String[] args) {
        System.out.println("Calling launch from main thread: "+Thread.currentThread());
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("start() invoked on thread: "+Thread.currentThread());
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((e)->System.out.println("Hello World!"));

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}