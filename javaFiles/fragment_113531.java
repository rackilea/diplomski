class MyClass {

    private String value;
    private boolean isSetValue;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        isSetValue = true;
    }

    public boolean getIsSetValue() {
        return isSetValue;
    }
}