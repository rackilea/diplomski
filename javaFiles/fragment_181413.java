this.getStylesheets().add("Fx_GUI/Style.css");
this.getStyleClass().add("cell");

// ...

int r = ... ;
int g = ... ;
int b = ... ;
this.setStyle(String.format("-cell-background: rgb(%d, %d, %d);", r, g, b));