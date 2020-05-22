public void close(){
    for (int row = 0; row < 4; row++){
        for (int col = 0; col < 4; col++){
            if (tiles[row][col] != null) {
                return; // leave this function and don't exit for any non-null tile
            }
        }
    }
    System.exit(0);
}