private void init() {
    whoseTurn = 'X';
    gameOver = false;
    jlblStatus = new JLabel("X's turn to play");
    for(Cell[] ca : cells) {
        for(Cell c : ca) {
            c.setToken(' ');
        }
    }
}