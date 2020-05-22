public class Test extends Application {

    private TrackableTextField tf_name = new TrackableTextField();
    private TrackableTextField tf_sname = new TrackableTextField();

    private Button save = new Button("Save");
    private Button discard = new Button("Discard");

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();

        root.add(new Label("Name: "), 0, 0);
        root.add(tf_name, 1, 0);

        root.add(new Label("Surname: "), 0, 1);
        root.add(tf_sname, 1, 1);

        root.add(save, 0, 2);
        root.add(discard, 1, 2);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();

        initialize();

    }

    private void initialize() {

        save.setDisable(true);
        discard.setDisable(true);

        save.disableProperty().bind(tf_name.dirtyProperty().or(tf_sname.dirtyProperty()).not());
        discard.disableProperty().bind(tf_name.dirtyProperty().or(tf_sname.dirtyProperty()).not());

        tf_name.setOriginalText("guleryuz");
        tf_sname.setOriginalText("guleryuz");

        save.setOnAction( e -> {
            tf_name.commit();
            tf_sname.commit();
        } );

        discard.setOnAction( e -> {
            tf_name.rollback();
            tf_sname.rollback();
        } );

    }

    public static void main(String[] args) {
        launch(args);
    }

}