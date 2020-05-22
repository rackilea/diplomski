double currentWidth = stage.getWidth();
    double currentHeight = stage.getHeight();
    WritableValue<Double> writableValue = new WritableValue<Double>() {
        private Double internal = 1.0;
        private boolean flag = true;
        @Override
        public Double getValue() {
            return internal;
        }

         @Override
         public void setValue(Double value) {
            if(flag) {
                stage.setWidth(currentWidth * value);
                stage.setHeight(currentHeight * value);
            } else {
                stage.setOpacity(value);
            }
            internal = value;
            flag = !flag;
        }
    };

    KeyFrame keyFrameMove = new KeyFrame(Duration.millis(MILLIS), onFinished, new KeyValue(x, 0d), new KeyValue(y, Screen.getPrimary().getBounds().getMaxY() - 25));
    KeyFrame keyFrame = new KeyFrame(Duration.millis(MILLIS), new KeyValue(writableValue, 0d));

    Timeline timeline = new Timeline(keyFrame, keyFrameMove);

    timeline.play();