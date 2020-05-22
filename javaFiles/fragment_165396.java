private draw(Pane parent, Piece piece, Color stroke, String dir) {
    Hexagon hexagon = new Hexagon();
    hexagon.setStroke(stroke);
    hexagon.setFill(stroke.invert());

    ImageView imageView = new ImageView("/hive/imagesPieces/" + dir + "/" + piece.getPiece() + ".png");
    Group group = new Group(hexagon, imageView);
    parent.getChildren().add(group);
}

public void draw() {
    for (Piece piece : pieces) {
        if (piece.isWhite()){
            draw(whitePieces, piece, Color.WHITE, "b");
        } else {
            draw(blackPieces, piece, Color.BLACK, "w");
        }
    }
}