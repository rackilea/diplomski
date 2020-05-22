@Override
public void render(Painter g) {
    cell[][] boardArr = board.getBoard();
    for(int r = 0; r<=board.getRow(); r++){
        for(int c = 0; c<=board.getCol(); c++){
            boardArr[r][c].cellMethod();
        }
    }
}