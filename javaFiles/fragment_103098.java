for (int y = 0; y < row; y++) {
    for (int x = 0; x < col; x++) {
        if(board[y][x] == 2){
           g2d.setColor(Color.BLACK);
           g2d.fillOval(y * 79, x * 79, 79, 79);
        } else if(board[y][x] == 1){
            g2d.setColor(Color.WHITE);
           g2d.fillOval(y * 79, x * 79, 79, 79);
        }
    }
}