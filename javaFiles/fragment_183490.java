Pane pane = new Pane();
pane.setPrefSize(400, 400);

MoveTo corner1 = new MoveTo();
LineTo corner2 = new LineTo();
LineTo corner3 = new LineTo();

Path path = new Path(corner1, corner2, corner3, new ClosePath());
pane.getChildren().add(path);

Timeline timeline = new Timeline(
        new KeyFrame(Duration.ZERO,
                new KeyValue(corner1.xProperty(), 200d),
                new KeyValue(corner1.yProperty(), 200d),
                new KeyValue(corner2.xProperty(), 200d),
                new KeyValue(corner2.yProperty(), 200d),
                new KeyValue(corner3.xProperty(), 200d),
                new KeyValue(corner3.yProperty(), 200d)),
        new KeyFrame(Duration.seconds(2),
                new KeyValue(corner1.xProperty(), 100d),
                new KeyValue(corner1.yProperty(), 100d),
                new KeyValue(corner2.xProperty(), 250d),
                new KeyValue(corner2.yProperty(), 300d),
                new KeyValue(corner3.xProperty(), 50d),
                new KeyValue(corner3.yProperty(), 380d)));
timeline.setCycleCount(Animation.INDEFINITE);
timeline.setAutoReverse(true);
timeline.play();