// Top-Left -> Bottom-Right
for (int column = 0; column < 4; column++) {
    for (int row = 0; row < 4; row++) {
        player = 0;
        if (field[row][column] != 0){
            player=field[row][column];
            offset = 1;
        }
        while (player != 0){
            if (field[row + offset][column + offset] == player){
                offset += 1;
            }else{
                player = 0;
            }
        }                   
        if(offset >= 4){
            return field[row][column];
        }
    }
}