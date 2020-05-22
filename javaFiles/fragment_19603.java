public class CustomTreeCell<T extends Node> extends TreeCell<T> {

    private static final PseudoClass HAPPY = PseudoClass.getPseudoClass("happy");
    private static final PseudoClass SAD = PseudoClass.getPseudoClass("sad");

    // this listener will activate/deactivate the appropriate PseudoClass states
    private final ChangeListener<NodeType> listener = (obs, oldVal, newVal) -> {
        pseudoClassStateChanged(HAPPY, newVal == NodeType.HAPPY);
        pseudoClassStateChanged(SAD, newVal == NodeType.SAD);
    };

    // use a weak listener to avoid a memory leak
    private final WeakChangeListener<NodeType> weakListener = /* wrap listener */;

    public CustomTreeCell() {
        getStyleClass().add("custom-tree-cell");
        itemProperty().addListener((obs, oldVal, newVal) -> {
            if (oldVal != null) {
                oldVal.nodeTypeProperty().removeListener(weakListener);
            }
            if (newVal != null) {
                newVal.nodeTypeProperty().addListener(weakListener);
                // need to "observe" the initial NodeType of the new Node item.
                // You could call the listener manually to avoid code duplication
                pseudoClassStateChanged(HAPPY, newVal.getNodeType() == NodeType.HAPPY);
                pseudoClassStateChanged(SAD, newVal.getNodeType() == NodeType.SAD);
            } else {
                // no item in this cell so deactivate all PseudoClass's
                pseudoClassStateChanged(HAPPY, false);
                pseudoClassStateChanged(SAD, false);
            }
        });
    }
}