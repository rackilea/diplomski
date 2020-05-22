private void createChangeListener(Property<?> property) {
  property.addListener(new ChangeListener<Object>() {
    @Override
    public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {                        
        Foo.this.propertyChanged(observable);
    }
  });
}