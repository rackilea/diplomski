ImageView im = new ImageView();
IntegerProperty intValue = new SimpleIntegerProperty();
List<Image> images = Arrays.asList(new Image(getClass().getResource("aa.png").toString()),
        new Image(getClass().getResource("bb.png").toString()));

im.imageProperty().bind(Bindings.createObjectBinding(() -> images.get(intValue.getValue()),
    intValue));