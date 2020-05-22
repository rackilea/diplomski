public class SomeBean {

    private final ObjectProperty<SomeFunctionalInterface> value = new SimpleObjectProperty<>();

    private final SomeFunctionalInterface defaultValue = () -> {} ;

    private final Binding<SomeFunctionalInterface> nonNullBinding = Bindings.createObjectBinding(() -> {
        SomeFunctionalInterface val = value.get();
        return val == null ? defaultValue : val ;
    }, property);

    public final Binding<SomeFunctionalInterface> valueProperty() {
        return nonNullBinding ;
    }

    public final SomeFunctionalInterface getValue() {
        return valueProperty().getValue();
    }

    public final void setValue(SomeFunctionalInterface value) {
        valueProperty.set(value);
    }

    // ...
}