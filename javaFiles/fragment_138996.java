protected static class BindingProperty extends SimpleStringProperty {

    public BindingProperty(final String bindingName, final String def) {
        super(PREFS.get(bindingName, def));
        this.addListener(
                (ChangeListener<String>) (observable, oldValue, newValue) -> PREFS.put(bindingName, newValue));
    }

    public BindingProperty(final String bindingName) {
        this(bindingName, "");
    }

}