nodeA.heightProperty().asObject().addListener(new ChangeListener<Double>() {
    @Override
    public void changed(ObservableValue< ? extends Double > observable,
                        Double oldValue,
                        Double newValue ) {
        final double ov = oldValue.doubleValue();
        final double nv = newValue.doubleValue();

        // do stuff
    }
});