.list-cell {
    -fx-background: lightblue;
}

.list-cell:user-message,
.list-cell:empty {
    -fx-background: -fx-control-inner-background;
}

.list-view:focused .list-cell:filled:selected {
    -fx-background: -fx-selection-bar;
}