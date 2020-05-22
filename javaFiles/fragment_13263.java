private static void addPiecesToBoard() {
    for(int i = 0; i < 8; i++) {
        //String test = "♙";
        String test = whitePawns[i].getWhitePieceIcon();
        b[6][i].setText(test);
    }
}