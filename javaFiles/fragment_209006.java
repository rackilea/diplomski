.dialog-pane > .button-bar > .container > .details-button {
  -fx-alignment: baseline-left;
  -fx-focus-traversable: false;
  -fx-padding: 0.416em; /* 5px */
}

.dialog-pane > .button-bar > .container > .details-button.more {
    -fx-graphic: url("dialog-more-details.png");
}

.dialog-pane > .button-bar > .container > .details-button.less {
    -fx-graphic: url("dialog-fewer-details.png");
}

.dialog-pane > .button-bar > .container > .details-button:hover {
    -fx-underline: true;
}