public enum MyType {

    FIRST_TYPE, SECOND_TYPE, THIRD_TYPE;

    private final MyConstantsWithLookup constants = GWT.create(MyConstantsWithLookup.class)

    public String getTitle() {
        return this.constants.getString(this.name());
    }
}