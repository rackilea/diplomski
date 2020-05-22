if (e.getClickCount() == 1) {
    // Single click
    ((NodeObject) node.getUserObject()).onSingleClick();
} else if (e.getClickCount() == 2) {
    // Double click
    ((NodeObject) node.getUserObject()).onDoubleClick();
}