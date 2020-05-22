private void setupBindings(ObjectProperty<String> selection) {
    bindingObj = createObjectBinding(selection);
    bindingBool = createBooleanBinding(selection);
    objectProperty.bind(bindingObj);
    booleanProperty.bind(bindingBool);

    objectProperty.addListener((a,b,c)-> {});
    booleanProperty.addListener((a,b,c)-> {});
}