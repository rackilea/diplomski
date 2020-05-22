int boardSize = 3;
ArrayList<ArrayList<Character>> board = new ArrayList<ArrayList<Character>>(boardSize);
for (int i = 0; i < boardSize; i++) {
    board.add(new ArrayList<Character>(boardSize));
    for (int j = 0; j < boardSize; j++){
        board.get(i).add('0');
    }
}