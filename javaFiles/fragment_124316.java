.custom-tree-cell:root .tree-disclosure-node,
.custom-tree-cell:root .arrow {

    -fx-min-width: 0;
    -fx-pref-width: 0;
    -fx-max-width: 0;

    -fx-min-height: 0;
    -fx-pref-height: 0;
    -fx-max-height: 0;

}

/* Related to question asked in the comments by OP */
.custom-tree-cell > .tree-disclosure-node > .arrow {
    -fx-shape: "M 0 0 L 10 5 L 0 10 L 0 8 L 8 5 L 0 2 Z";
}