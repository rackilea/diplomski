private static JButton[][] b = createBoard();

private static JButton[][] createBoard() {
    JButton[][] b = new JButton[8][8];
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            b[i][j] = new JButton();
        }
    }
    return b;
}