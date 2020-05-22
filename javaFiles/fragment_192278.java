class MyString {
    private String value;

    public MyString(String value) {
        this.value = value;
    }

    void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
       return value;
    }
}