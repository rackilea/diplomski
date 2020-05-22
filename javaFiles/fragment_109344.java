public class TooltipTableCell<S, T> extends TableCell<S, T> {

    private final Tooltip tooltip = new Tooltip();
    private final Text measureText = new Text();
    private Node textDisplay;
    private final InvalidationListener listener = o -> {
        setTooltip((measureText.getBoundsInLocal().getWidth() > textDisplay.getBoundsInLocal().getWidth()) ? tooltip : null);
    };

    @Override
    protected void layoutChildren() {
        super.layoutChildren();

        measureText.boundsInLocalProperty().addListener(listener);
        Node oldTextDisplay = textDisplay;
        textDisplay = lookup("LabeledText"); // lookup node displaying the text via CSS

        if (oldTextDisplay != textDisplay) {
            if (oldTextDisplay != null) {
                oldTextDisplay.boundsInLocalProperty().removeListener(listener);
            }
            textDisplay.boundsInLocalProperty().addListener(listener);
            listener.invalidated(null);
        }
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);

        String newText = empty || item == null ? "" : item.toString();
        setText(newText);
        tooltip.setText(newText);
        measureText.setText(newText);
    }

    public static <E, F> Callback<TableColumn<E, F>, TableCell<E, F>> forTableColumn() {
        return column -> new TooltipTableCell<>();
    }

}