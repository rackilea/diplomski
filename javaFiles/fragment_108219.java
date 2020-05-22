class CoBoItem {
    private final String display;
    private final float value;

    // constructor to create your data objects
    CoBoItem(String display, float value) {
        this.display = display;
        this.value = value;
    }
    // methods to get the values
    String getDisplay() {
        return display;
    }

    float getValue() {
        return value;
    }
    // this will be displayed in the JComboBox
    @Override
    public String toString() {
        return display;
    }
}