.titled-pane {
    -fx-skin: "com.example.CustomTitledPaneSkin";
    -fx-arrow-side: right;
}

/*
 * The arrow button has some right padding that's added
 * by "modena.css". This simply puts the padding on the
 * left since the arrow is positioned on the right.
 */
.titled-pane > .title > .arrow-button {
    -fx-padding: 0.0em 0.0em 0.0em 0.583em;
}