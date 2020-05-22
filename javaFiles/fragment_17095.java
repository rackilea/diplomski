private static class MyItem {
    private String value;

    public MyItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value; //this is what display in the JComboBox
    }
}