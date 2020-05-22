public class FanWithControls extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        FanPane fan = new FanPane();
        FlowPane spane = new FlowPane();
        spane.getChildren().addAll(fan);
        HBox hBox = new HBox(5);
        Button btPause = new Button("Pause");
        Button btResume = new Button("Resume");
        Button btReverse = new Button("Reverse");
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btPause, btResume, btReverse);
        Slider slider = new Slider(0, 10, 3);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        BorderPane pane = new BorderPane();
        pane.setCenter(spane);
        pane.setTop(hBox);
        pane.setBottom(slider);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 400);
        primaryStage.setTitle("FanWithControls"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        fan.setAnimation(fan);
        Timeline animation = fan.getAnimation();

        scene.widthProperty().addListener(e -> fan.setW(fan.getWidth()));
        scene.heightProperty().addListener(e -> fan.setH(fan.getHeight()));

        btPause.setOnAction((e) -> {
            for (Node fans : spane.getChildren()) {
                FanPane fanpane = (FanPane) fans;
                fanpane.getAnimation().pause();
            }
//            animation.pause();
        });
        btResume.setOnAction((e) -> {
            for (Node fans : spane.getChildren()) {
                FanPane fanpane = (FanPane) fans;
                fanpane.getAnimation().play();
            }
//            animation.play();
        });
        btReverse.setOnAction((e) -> {
            for (Node fans : spane.getChildren()) {
                FanPane fanpane = (FanPane) fans;
                fanpane.reverse();
            }
//            fan.reverse();
        });

        slider.valueProperty().addListener((ov) -> {
//            animation.setRate(slider.getValue());
            for (Node fans : spane.getChildren()) {
                FanPane fanpane = (FanPane) fans;
                fanpane.getAnimation().setRate(slider.getValue());
            }
            if (spane.getChildren().size() < (int) slider.getValue()) {
                for (int i = spane.getChildren().size(); i < (int) slider.getValue(); i++) {
                    FanPane fanPane = new FanPane();
                    spane.getChildren().add(fanPane);
                    fanPane.setAnimation(fanPane);
                    fanPane.getAnimation().setRate(slider.getValue());
                }
            } else if (spane.getChildren().size() > (int) slider.getValue()) {
                for (int i = (int) slider.getValue(); i < spane.getChildren().size(); i++) {
                    spane.getChildren().remove(spane.getChildren().size() - 1);
                }
            }
        });

    }

    /**
     * The main method is only needed for the IDE with limited JavaFX support.
     * Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }

    class FanPane extends Pane {

        private double w = 200;
        private double h = 200;
        private double radius = Math.min(w, h) * 0.45;
        private Arc arc[] = new Arc[4];
        private double startAngle = 30;
        private Circle circle = new Circle(w / 2, h / 2, radius);
        private Timeline animation;

        public FanPane() {
            circle.setStroke(Color.BLUE);
            circle.setFill(Color.WHITE);
            circle.setStrokeWidth(4);
            getChildren().add(circle);

            for (int i = 0; i < 4; i++) {
                arc[i] = new Arc(w / 2, h / 2, radius * 0.9, radius * 0.9, startAngle + i * 90, 35);
                arc[i].setFill(Color.RED); // Set fill color
                arc[i].setType(ArcType.ROUND);
                getChildren().addAll(arc[i]);
            }

        }

        public Timeline getAnimation() {
            return animation;
        }

        public void setAnimation(FanPane fan) {
            this.animation = new Timeline(new KeyFrame(Duration.millis(50), e -> fan.move()));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();
        }

        private double increment = 5;

        public void reverse() {
            increment = -increment;
        }

        public void move() {
            setStartAngle(startAngle + increment);
        }

        public void setStartAngle(double angle) {
            startAngle = angle;
            setValues();
        }

        public void setValues() {
            radius = Math.min(w, h) * 0.45;
            circle.setRadius(radius);
            circle.setCenterX(w / 2);
            circle.setCenterY(h / 2);

            for (int i = 0; i < 4; i++) {
                arc[i].setRadiusX(radius * 0.9);
                arc[i].setRadiusY(radius * 0.9);
                arc[i].setCenterX(w / 2);
                arc[i].setCenterY(h / 2);
                arc[i].setStartAngle(startAngle + i * 90);
            }
        }

        public void setW(double w) {
            this.w = w;
            setValues();
        }

        public void setH(double h) {
            this.h = h;
            setValues();
        }

        public double getCenterX() {
            return circle.getCenterX();
        }

        public double getCenterY() {
            return circle.getCenterY();
        }

        public double getRadius() {
            return circle.getRadius();
        }

    }
}