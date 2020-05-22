public class PercantageFormatCell extends TableCell<Object, Double> {

    public PercantageFormatCell() {
    }

    @Override
    protected void updateItem(Double item, boolean empty) {
        super.updateItem(item, empty);

        // If the row is not empty but the Double-value is null,
        // we will always display 0%
        if (!empty && null == item) {
            item = new Double(0.0d);
        }

        // Here we set the displayed text to anything we want without changing the
        // real value behind it. We could also have used switch case or anything you
        // like.
        setText(item == null ? "" : NumberFormat.getPercentInstance().format(item));

        // If the cell is selected, the text will always be white
        // (so that it can be read against the blue background),
        // if the value is 1 it will be green.
        if (item != null) {
            double value = item.doubleValue();
            if (isFocused() || isSelected() || isPressed()) {
                setTextFill(Color.WHITE);
            } else if (value < 1) {
                setTextFill(Color.BLACK);
            } else {
                setTextFill(Color.GREEN);
            }
        }
    }
}