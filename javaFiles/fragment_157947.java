ComboBox<MyEnum> myComboBox = new ComboBox<>();
myComboBox.getItems().setAll(MyEnum.values());
myComboBox.setConverter(new StringConverter<MyEnum>() {

    @Override
    public String toString(MyEnum object) {
        switch (object) {
        case FIRST_CHOICE:
            return "foo";
        case SECOND_CHOICE:
            return "bar";
        default:
            break;
        }
        return null;
    }

    @Override
    public MyEnum fromString(String string) {
        return null;
    }
});