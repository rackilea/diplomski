.menu-item {
/*    -fx-skin: "com.sun.javafx.scene.control.skin.MenuItemSkin";*/
    -fx-background-color: transparent;
    -fx-padding: 0em; /* do not pad for item. we want to ccupy all spaces for graphics only */
}

.menu-item:focused {
     -fx-background: -fx-accent;
     -fx-background-color: -fx-selection-bar;
     -fx-text-fill: -fx-selection-bar-text;
}

.menu-item .graphic-container {
    -fx-padding: 0em; /* do not pad for graphics, label graphic pads itself */
}

.menu-item .label {
    -fx-padding: 0em;  /* do not pad for label, since there is no label text set */
    -fx-text-fill: -fx-text-base-color;
}