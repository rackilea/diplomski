// For tabs in general
.tab { -fx-background-color: red; }
.tab .tab-label { -fx-text-fill: yellow;}
.tab:hover { -fx-background-color: cyan; }

// Only for the main tab-pane
.main-tab-pane > .tab-header-area > .headers-region > .tab {
    -fx-background-color: blue;
}

.main-tab-pane > .tab-header-area > .headers-region > .tab:hover {
    -fx-background-color: green;
}

.main-tab-pane > .tab-header-area > .headers-region >  .tab > .tab-container >  .tab-label{
    -fx-text-fill: white;
}