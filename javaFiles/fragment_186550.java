public class GenderTableCell<T> extends TableCell<T, Gender> {
    @Override
    protected void updateItem(Gender item, boolean empty) {
        super.updateItem(item, empty);
        setText(empty || item == null ? "" : item.getGender());
    }
}