listView.setCellFactory(new Callback<ListView<MyDataType>, ListCell<MyDataType>>() {
    @Override
    public ListCell<MyDataType> call(ListView<MyDataType> lv) {
        return new ListCell<MyDataType>() {
            @Override
            public void updateItem(MyDataType item, boolean empty) {
                super.updateItem(item, empty);
                textProperty().unbind();
                if (item != null) {
                    // assumes MyDataType.someProperty() returns a StringProperty:
                    textProperty.bind(item.someProperty());
                }
            }
        };
    }
});