public void movePawn(int x1, int y1, int x2, int y2) {
    Platform.runLater(() -> {
        Pawn pawnTemp = game.getBoard().getField(x1, y1).getPawn();
        game.getBoard().getField(x1, y1).setPawn(null);
        game.getBoard().getField(x2, y2).setPawn(pawnTemp);

        refresh();
    });
}