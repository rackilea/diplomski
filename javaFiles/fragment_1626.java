ComboBox<MyData> comboBox = new ComboBox<>();
MyData data1 = new MyData("Gelbooru", "https://gelbooru.com/favicon.ico");
MyData data2 = new MyData("Danbooru", "https://i.imgur.com/7ek8bNs.png");
comboBox.getItems().addAll(data1, data2);
comboBox.setCellFactory(param -> new ListCell<>() {
    final ImageView graphicNode = new ImageView();

    @Override
    protected void updateItem(MyData item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty) {
            setText(null);
            setGraphic(null);
            graphicNode.setImage(null);
        } else {
            setText(item.getName());
            graphicNode.setImage(item.getImage());
            setGraphic(graphicNode);
        }
    }
});