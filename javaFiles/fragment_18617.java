DoubleBinding vSliderBind = new DoubleBinding() {
    {
        super.bind(vSlider.valueProperty());
    }

    @Override
    protected double computeValue() {
        return vSlider.getValue();
    }
};

rectangle.heightProperty().bind(vSliderBind);