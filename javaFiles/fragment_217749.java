myTable.addCellPreviewHandler(new Handler<MyObject>() {

    @Override
    public void onCellPreview(CellPreviewEvent<MyObject> event) {
        if ("click".equals(event.getNativeEvent().getType())) {
            if (event.getColumn() == 0 || event.getColumn() == 1) {
                MyObject object = event.getValue();
                Window.alert("Column clicked: " + event.getColumn());
            }
        }
    }

});