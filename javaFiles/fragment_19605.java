/*
 * Create a custom TreeCell like in the first option but
 * without any of the PseudoClass code. This listener should
 * be added/removed from the Node item just like weakListener
 * is above.
 */
ChangeListener<NodeType> listener = (obs, oldVal, newVal) -> {
    // You have to make sure you keep "cell", "indexed-cell", and "tree-cell"
    // in order to keep the basic modena styling.
    if (newVal == NodeType.HAPPY) {
        getStyleClass().setAll("cell", "indexed-cell", "tree-cell", "custom-tree-cell-happy");
    } else if (newVal == NodeType.HAPPY) {
        getStyleClass().setAll("cell", "indexed-cell", "tree-cell", "custom-tree-cell-sad");
    } else {
        getStyleClass().setAll("cell", "indexed-cell", "tree-cell"); // revert to regular TreeCell style
    }
};