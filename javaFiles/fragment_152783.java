private static class MyButton extends Button {

    private static final List<CssMetaData<? extends Styleable, ?>> CLASS_CSS_METADATA;
    private static final CssMetaData<MyButton, Boolean> SELECTED;

    static {
        SELECTED = new CssMetaData<MyButton, Boolean>("-my-selected", StyleConverter.getBooleanConverter()) {

            @Override
            public boolean isSettable(MyButton styleable) {
                // not setable, if bound or set by user
                return styleable.selected.getStyleOrigin() != StyleOrigin.USER  && !styleable.selected.isBound();
            }

            @Override
            public StyleableProperty<Boolean> getStyleableProperty(MyButton styleable) {
                return styleable.selected;
            }

        };

        // copy list of button css metadata to list and add new metadata object
        List<CssMetaData<? extends Styleable, ?>> buttonData = Button.getClassCssMetaData();
        List<CssMetaData<? extends Styleable, ?>> mybuttonData = new ArrayList<>(buttonData.size()+1);
        mybuttonData.addAll(buttonData);
        mybuttonData.add(SELECTED);
        CLASS_CSS_METADATA = Collections.unmodifiableList(mybuttonData);
    }

    MyButton(String labelText) {
        super(labelText);
        getStyleClass().add("my-button");
        setStyle("-my-selected: true");
    }

    // Typical JavaFX property implementation
    public ObservableValue<Boolean> selectedProperty() { return selected; }
    public final boolean isSelected() { return selected.get(); }
    public final void setSelected(boolean isSelected) { selected.set(isSelected); }

    // StyleableProperty implementation reduced to one line
    private final SimpleStyleableBooleanProperty selected = new SimpleStyleableBooleanProperty(SELECTED, this, "selected");

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
        return CLASS_CSS_METADATA;
    }

    public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
        return CLASS_CSS_METADATA;
    }

}