ObservableList<SomeObservableClass> observableList = FXCollections.observableArrayList(
            e -> new Observable[]{e.prop1Property(), e.prop2Property()});

// add items and set listeners here

observableList.get(1).setProp1("newVal");
// It fires InvalidationListener and ListChangeListener.