/* a button in a hovered container should look the same as a hovered button */
.hover-container:hover .button {
    -fx-color: -fx-hover-base;
}

/* override above rule for armed buttons */
.hover-container:hover .button:armed {
    -fx-color: -fx-pressed-base;
}