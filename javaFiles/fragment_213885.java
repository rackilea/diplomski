ObjectProperty<Integer> objectProp = new SimpleObjectProperty<>(MIN);
IntegerProperty integerProperty = IntegerProperty.integerProperty(objectProp);

Spinner<Integer> spinner = new Spinner<>(MIN, MAX, STEP);

spinner.getValueFactory().valueProperty().bindBidirectional(objectProp);