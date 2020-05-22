for (int x = 0; x < size; x++) {
    for (int y = 0; y < size; y++) {
        this.playBoard[x][y] = new FieldClass(x, y);
     }
}

for (int x = 0; x < size; x++) {
    for (int y = 0; y < size; y++) {
        Field neighbours[] = new Field[8];

        neighbours[0] = x-1 >= 0 && x-1 < 8 ? this.playBoard[x-1][y] : null;
        neighbours[1] = x-1 >= 0 && x-1 < 8 && y+1 >= 0 && y+1 < 8 ? this.playBoard[x-1][y+1] : null;
        neighbours[2] = y+1 >= 0 && y+1 < 8 ? this.playBoard[x][y+1] : null;
        neighbours[3] = x+1 >= 0 && x+1 < 8 && y+1 >= 0 && y+1 < 8 ? this.playBoard[x+1][y+1] : null;
        neighbours[4] = x+1 >= 0 && x+1 < 8 ? this.playBoard[x+1][y] : null;
        neighbours[5] = x+1 >= 0 && x+1 < 8 && y-1 >= 0 && y-1 < 8 ? this.playBoard[x+1][y-1] : null;
        neighbours[6] = y-1 >= 0 && y-1 < 8 ? this.playBoard[x][y-1] : null;
        neighbours[7] = x-1 >= 0 && x-1 < 8 && y-1 >= 0 && y-1 < 8 ? this.playBoard[x-1][y-1] : null;

        System.out.println("X: "+x+", Y: "+y);
        for(int i = 0; i < neighbours.length; i++)
            System.out.println("    "+neighbours[i]);

        this.playBoard[x][y].setNeighbours(neighbours));
     }
}