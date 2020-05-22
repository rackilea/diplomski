.progress-indicator:indeterminate > .spinner {
    /** Applying to undo styling from .spinner, reported in RT-37965 */
    -fx-background-color: red;
    /* originally was */
    /*-fx-background-color: transparent;*/
    -fx-background-insets: 0;
    -fx-background-radius: 0;
}