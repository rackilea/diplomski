public class Child {
    private final BooleanProperty single = new SimpleBooleanProperty();

    public BooleanProperty singleProperty() {
        return single ;
    }

    public final boolean isSingle() {
        return singleProperty().get();
    }

    public final void setSingle(boolean single) {
        singleProperty().set(single);
    }
}