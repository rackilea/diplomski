for (int[] row : board) {
    for (int col : row) {
        if(col==SnakesAndLadders.computerPos)
            System.out.printf("%4s", "<" + SnakesAndLadders.computerPos + ">");
        else if(col==SnakesAndLadders.player1Pos)
            System.out.printf("%4s", "(" + SnakesAndLadders.player1Pos + ")");
        else
            System.out.printf("%4d", col);
    }
    System.out.println();
}