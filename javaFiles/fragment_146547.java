.cell-renderer-changed {
    my-bg: rgba(255, 248, 33, .5);
    -fx-background-color: my-bg;
}

.cell-renderer-error {
    my-bg: rgba(255, 159, 160, .5);
    -fx-background-color: my-bg;
}

.cell-renderer-error-and-changed {
    my-bg: rgba(255, 205, 158, .5);
    -fx-background-color: my-bg;
}

/* Restore default behaviour from caspian.css */
.cell-renderer-changed:hover, .cell-renderer-error:hover, .cell-renderer-error-and-changed:hover {
    -fx-background-color: -fx-table-cell-border-color, -fx-cell-hover-color;
    -fx-background-insets: 0, 0 0 1 0;
}

.cell-renderer-changed:selected, .cell-renderer-error:selected, .cell-renderer-error-and-changed:selected {
    -fx-background: -fx-accent;
    -fx-background-color: -fx-selection-bar;
    -fx-text-fill: -fx-selection-bar-text;
    -fx-background-insets: 0 0 1 0;
}

.cell-renderer-changed:focused:selected, .cell-renderer-error:focused:selected, .cell-renderer-error-and-changed:focused:selected {
    -fx-background-color: -fx-focus-color, -fx-cell-focus-inner-border, -fx-selection-bar;
    -fx-background-insets: 0 1 0 0, 1 2 1 1, 2 3 2 2;
    -fx-background: -fx-accent;
    -fx-text-fill: -fx-selection-bar-text;
}

.cell-renderer-changed:focused, .cell-renderer-error:focused, .cell-renderer-error-and-changed:focused {
    -fx-background-color: -fx-focus-color, -fx-cell-focus-inner-border, my-bg;
    /*-fx-background-color: -fx-focus-color, -fx-cell-focus-inner-border, transparent;*/
    -fx-background-insets: 0 1 0 0, 1 2 1 1, 2 3 2 2;
}