* {
    -fx-focus-color: transparent;
    -fx-faint-focus-color: transparent;

    -fx-background-radius: 0;
    -fx-background-insets: 0;

    -fx-border-radius: 0;
    -fx-border-insets: 0;
}

/* presentation tab */

.tab {
    -fx-background-color: transparent, tab-border-color , tab-color;
    tab-color: linear-gradient(light-tab-color, dark-tab-color) ;
    tab-border-color : dark-tab-color ;
    dark-tab-color: #721b1b ;
    light-tab-color: #9b2626 ;
    -fx-background-insets: 0, 0 5 0 0, 1 6 0 0 ;
    -fx-padding: 4 10 4 4 ;
}

.tab-label {
    -fx-text-fill: white;
}

.tab:hover {
    tab-color: light-tab-color ;
}

.tab:pressed {
    tab-color: dark-tab-color;
}