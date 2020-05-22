.slider, .progress-bar {
    -slider-track-color: derive(-fx-control-inner-background, -5%) ;
}

.slider .track, .progress-bar .track {
    -fx-background-color: 
        -fx-shadow-highlight-color,
        linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),
        -slider-track-color ;
}

.progress-bar .bar {
    -fx-background-color: transparent ;
}