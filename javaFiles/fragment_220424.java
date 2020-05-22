private <T> void createChangeListener(Property<T> property) {
  property.addListener(new ChangeListener<T>() {
    @Override
    public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {                        
        Foo.this.propertyChanged(observable);
    }
  });
}