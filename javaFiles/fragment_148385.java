wheel.rotateProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, 
                            Number oldValue, 
                            Number newValue) {
            System.err.println("Rotation of " + newValue + " degrees");
        }
    });