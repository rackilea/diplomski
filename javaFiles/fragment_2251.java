public class RemoveCell<T> extends TableCell<T, Void> {

    private final Hyperlink link;

    public RemoveCell() {
        link = new Hyperlink("Remove");
        link.setOnAction(evt -> {
            // remove row item from tableview
            getTableView().getItems().remove(getTableRow().getIndex());
        });
    }

    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);

        setGraphic(empty ? null : link);
    }

}