ListView<MyDataType> listView = new ListView<>();
listView.setCellFactory(new Callback<ListView<MyDataType>, ListCell<MyDataType>>() {
    @Override
    public ListCell<MyDataType> call(ListView<MyDataType> lv) {
        return new ListCell<MyDataType>() {
            @Override
            public void updateItem(MyDataType item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null) {
                    setText(null);
                } else {
                    // assume MyDataType.getSomeProperty() returns a string
                    setText(item.getSomeProperty());
                }
            }
        };
    }
});