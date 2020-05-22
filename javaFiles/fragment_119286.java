//Iterate over each 'block'
for (int row = 0; row < 3; row++) {
    for (int col = 0; col < 3; col++) {
        //Iterate over each cell in the block
        for (int i = row*3; i < (row+1)*3; i++) {
            for (int j = col*3; j < (col+1)*3; j++) {
                copyArray[(i - 3) * 3 + j - 3] = field[i][j];
            }
        }

        //Sort array and do duplication check here - return false if dupe found
    }
}
return true