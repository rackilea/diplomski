AnchorPane anchorRoot;
    double initX;
    double initY;
    ImageView iv = new ImageView(image);
    final double maxX = iv.getImage().getWidth();
    final double maxY = iv.getImage().getHeight();

    anchorRoot.getChildren().add(iv);

    iv.setOnMousePressed(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent me) {
            //System.out.println("Clicked, x:" + me.getSceneX() + " y:" + me.getSceneY());
            //the event will be passed only to the circle which is on front
            initX = me.getSceneX();
            initY = me.getSceneY();
            me.consume();
        }
    });
    iv.setOnMouseDragged(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent me) {
            //System.out.println("Dragged, x:" + me.getSceneX() + " y:" + me.getSceneY());
            if (me.getSceneX() < maxX && me.getSceneY() < maxY) {
                Line line = new Line(initX, initY, me.getSceneX(), me.getSceneY());
                line.setFill(null);
                line.setStroke(Color.RED);
                line.setStrokeWidth(2);
                anchorRoot.getChildren().add(line);
            }

            initX = me.getSceneX() > maxX ? maxX : me.getSceneX();
            initY = me.getSceneY() > maxY ? maxY : me.getSceneY();
        }
    });