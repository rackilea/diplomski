IntegerProperty someIntProperty = ... ;

BooleanProperty forceDisable = new SimpleBooleanProperty();

hboxSomeHBox.disableProperty().bind(new BooleanBinding() {
    {
        bind(someIntValue, forceDisable);
    }

    @Override
    public boolean computeValue() {
        return someIntValue.get() >= 2 || forceDisable.get() ;
    }
}