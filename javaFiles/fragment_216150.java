/* "default" style when hovered/pressed */
.custom-text-field>.text-field:hover,
.custom-text-field>.text-field:pressed {
    -fx-background-color: linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),
        linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background);

    -fx-highlight-fill: dodgerblue;      
    -fx-highlight-text-fill: white;
    -fx-display-caret: true;
}

.custom-text-field>.text-field:hover:focused,
.custom-text-field>.text-field:pressed:focused {
    -fx-background-color:
        -fx-focus-color,
        -fx-control-inner-background,
        -fx-faint-focus-color,
        linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background);

    -fx-highlight-fill: dodgerblue;      
    -fx-highlight-text-fill: white;
    -fx-display-caret: true;
}

/* Hide everything but text when neither hovered nor pressed */
.custom-text-field>.text-field,
.custom-text-field>.text-field:focused {
    -fx-background-color:
        null, null, null, null;
    -fx-highlight-fill: null;    
    -fx-highlight-text-fill: black;
    -fx-display-caret: false;
}
.custom-text-field:hover>.text-field:focused,
.custom-text-field>.text-field:pressed:focused {
    -fx-background-color:
        -fx-focus-color,
        -fx-control-inner-background,
        -fx-faint-focus-color,
        linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background);

    -fx-highlight-fill: dodgerblue;      
    -fx-highlight-text-fill: white;
    -fx-display-caret: true;
}

.custom-text-field>.text-field,
.custom-text-field>.text-field:focused {
    -fx-background-color:
        null, null, null, null;
    -fx-highlight-fill: null;    
    -fx-highlight-text-fill: black;
    -fx-display-caret: false;
}