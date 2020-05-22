tColumns[i].setCellFactory(column ->  new TableCell<M, String>() {
    private final Text txt = new Text();

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null || empty){
            setGraphic(null);
        } else {
            txt.setText(item);
            txt.setWrappingWidth(width-7);
            setGraphic(txt);
        }
    }

});