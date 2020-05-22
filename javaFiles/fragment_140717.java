TextField text = new TextField("Text");
    text.setConverter(new ByteToStringConverter());
    binder.bind(text, "text");
    layout.addComponent(text);
    TextField result = new TextField("Expected Result");
    result.setConverter(new ByteToStringConverter());
    binder.bind(result, "expectedResult");
    layout.addComponent(result);