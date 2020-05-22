public class User {
    private final ObjectProperty<Options> options = new SimpleObjectProperty<>(this, "options", new Options());
    public final Options getOptions() {
        return options.get();
    }
    public final void setOptions(Options options) {
        this.options.set(options);
    }
    public ObjectProperty<Options> optionsProperty() {
        return options ;
    }

    // other properties, etc...
}