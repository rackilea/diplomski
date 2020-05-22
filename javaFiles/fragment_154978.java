for (int i = 0; i < 9; i++) {
    for (int j = 0; j < 9; j++) {
        label[i][j].setText(
               String.valueOf(board.getDigit(i, j).getNum())
        );
    }
}