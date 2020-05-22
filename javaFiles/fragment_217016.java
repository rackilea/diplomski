@Override 
protected void updateItem(Color color, boolean empty) {
    super.updateItem(color, empty);

    int r = (int) (color.getRed() * 255);
    int g = (int) (color.getGreen() * 255);
    int b = (int) (color.getBlue() * 255);

    if (empty || color == null) {
        this.setStyle("-fx-background-color: white; "
             + "-fx-border-color: transparent -fx-table-cell-border-color -fx-table-cell-border-color transparent;");
    } else {
        this.setStyle("-fx-background-color: rgb(" + r + "," + g + "," + b + ");" 
             + "-fx-border-color: transparent -fx-table-cell-border-color -fx-table-cell-border-color transparent;");
    }

}