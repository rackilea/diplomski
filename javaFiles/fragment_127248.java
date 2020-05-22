nodeA.heightProperty().addListener(new ChangeListener<Number>() {
    @Override
    public void changed(ObservableValue< ? extends Number > observable,
                        Number oldValue,
                        Number newValue ) {
        final double ov = oldValue.doubleValue();
        final double nv = newValue.doubleValue();

        // do stuff with nodeA.heightProperty() ...
    }
});