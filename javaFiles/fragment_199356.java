public class Main extends Application {

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println(getParameters().getRaw().toString());
        getParameters().getNamed().forEach((name, string) -> {
            System.out.println("Parameter[" + name + "]=" + string);
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(new Pane() {{
            getChildren().add(new Button("B"));
        }}));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}