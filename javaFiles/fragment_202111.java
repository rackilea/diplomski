IntegerProperty intProperty = new SimpleIntegerProperty();
ObjectProperty<Color> colorProperty = colorPicker.valueProperty();

ObjectBinding<Color> colorBinding = Bindings.createObjectBinding(() -> intToColor(intProperty.get()), intProperty);
colorProperty.bind(colorBinding);
IntegerBinding intBinding = Bindings.createIntegerBinding(() -> colorToInt(colorProperty.get()), colorProperty);
intProperty.bind(intBinding);