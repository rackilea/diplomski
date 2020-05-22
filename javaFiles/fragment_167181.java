myEnumColumn.setCellFactory((param) -> new ComboBoxTableCell<>(new StringConverter<MyEnum>() {
            @Override public String toString(MyEnum object) {
                return object.getName();
            }

            @Override public MyEnum fromString(String string) {
                return MyEnum.valueOf(string);
            }
        }, MyEnum.values()));