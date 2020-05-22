tree.setCellFactory(new Callback<TreeView<Object>, TreeCell<Object>>() {
    @Override
    public TreeCell<Object> call(TreeView<Object> p) {
        return new TextFieldTreeCell<Object>(new StringConverter<Object>(){

            @Override
            public String toString(Object object) {
                return object.toString();
            }

            @Override
            public Object fromString(String string) {
                return new Object();
            }
        });
    }
});