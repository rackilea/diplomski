StringConverter<Number> rangeSliderLabelFormatter; // Implement a regular StringConverter to convert the values as needed.

rangeSlider.skinProperty().addListener(new ChangeListener<Skin<?>>() {
                @Override
                public void changed(ObservableValue<? extends Skin<?>> observable, Skin<?> oldValue, Skin<?> newValue) {
                    if (newValue != null) {
                        if (newValue instanceof RangeSliderSkin) {
                            RangeSliderSkin rangeSliderSkin = (RangeSliderSkin) newValue;
                            if (rangeSliderSkin.getChildren().get(0) instanceof NumberAxis) {
                                NumberAxis containedNumberAxis = (NumberAxis) rangeSliderSkin.getChildren().get(0);
                                containedNumberAxis.setTickLabelFormatter(rangeSliderLabelFormatter);
                            }
                        }
                    }
                }
            });