private static Font getFont(Font font, Integer size) {
    return Font.font(font == null ? null : font.getFamily(), size == null ? -1d : size.doubleValue());
}

@Override
public void start(Stage primaryStage) throws Exception {
    ComboBox<Font> fontSelector = new ComboBox<>();
    fontSelector.getItems().addAll(Font.getFamilies().stream().map(name -> Font.font(name, 14)).toArray(Font[]::new));

    ComboBox<Integer> size = new ComboBox<>();
    size.getItems().addAll(10, 11, 12, 14, 16, 18, 20, 24, 30, 36, 40, 48, 60, 72);

    Label fontLabel = new Label("Hello World");

    // bind font based on size/family
    fontLabel.fontProperty()
            .bind(Bindings.createObjectBinding(() -> getFont(fontSelector.getValue(), size.getValue()),
                    fontSelector.valueProperty(), size.valueProperty()));

    class FontListCell extends ListCell<Font> {

        @Override
        public void updateItem(Font item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null) {
                setText(item.getFamily());
                setFont(item);
            } else {
                setText("");
                setFont(Font.font(14));
            }
        }
    }

    fontSelector.setCellFactory(lv -> new FontListCell());
    fontSelector.setButtonCell(new FontListCell());

    Scene scene = new Scene(new VBox(fontSelector, size, fontLabel), 300, 500);
    primaryStage.setScene(scene);
    primaryStage.show();
}