public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label tekst = new Label();
        Button someButton = new LabelUpdatingButton("Button text", tekst);
        // etc...
    }
}