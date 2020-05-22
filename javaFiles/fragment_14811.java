public class QuickFlip extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BooleanProperty showFront = new SimpleBooleanProperty(true);

        Node card = createCard(showFront,
                new Image("http://www.ohmz.net/wp-content/uploads/2012/05/Game-of-Throne-Magic-trading-cards-2.jpg"),
                new Image("https://upload.wikimedia.org/wikipedia/en/a/aa/Magic_the_gathering-card_back.jpg")
                );

        stage.setScene(createScene(card));
        stage.show();

        // first 90° -> show front
        RotateTransition rotator1 = createRotator(card, 0, 90);

        // from 90° to 270° show backside
        rotator1.setOnFinished(evt -> showFront.set(false));
        RotateTransition rotator2 = createRotator(card, 90, 270);

        // from 270° to 360° show front again
        rotator2.setOnFinished(evt -> showFront.set(true));
        RotateTransition rotator3 = createRotator(card, 270, 360);

        SequentialTransition rotator = new SequentialTransition(card, rotator1, rotator2, rotator3);
        rotator.setCycleCount(10);
        rotator.play();
    }

    private Scene createScene(Node card) {
        StackPane root = new StackPane();
        root.getChildren().addAll(card);

        Scene scene = new Scene(root, 600, 700, true, SceneAntialiasing.BALANCED);
        scene.setCamera(new PerspectiveCamera());

        return scene;
    }

    private Node createCard(BooleanProperty showFront, Image front, Image back) {
        ImageView imageView = new ImageView();

        imageView.setFitHeight(front.getHeight());
        imageView.setFitWidth(front.getWidth());

        // show front/back depending on value of the showFront property
        imageView.imageProperty().bind(Bindings.when(showFront).then(front).otherwise(back));

        // mirror image, when backside is shown to prevent wrong orientation
        imageView.scaleXProperty().bind(Bindings.when(showFront).then(1d).otherwise(-1d));
        return imageView;
    }

    private RotateTransition createRotator(Node card, double fromAngle, double toAngle) {
        // animation length proportional to the rotation angle
        RotateTransition rotator = new RotateTransition(Duration.millis(Math.abs(10000 * (fromAngle - toAngle) / 360)), card);
        rotator.setAxis(Rotate.Y_AXIS);
        rotator.setFromAngle(fromAngle);
        rotator.setToAngle(toAngle);
        rotator.setInterpolator(Interpolator.LINEAR);

        return rotator;
    }

    public static void main(String[] args) {
        launch();
    }
}