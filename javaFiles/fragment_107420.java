static public int calc(int[][] grid, int rows, int columns){

int[][] check = new int[rows][columns];

int max, pos;

for(int i=0; i<rows; i++){
    max = grid[i][0];
    pos = 0;
    for(int j=0; j<columns; j++){
        if(grid[i][j] >= max){
            max = grid[i][j];
            pos = j;
        }
    }
    check[i][pos] = max; // updated here
}

for(int j=0; j<columns; j++){
    max = grid[0][j];
    pos = 0;
    for(int i=0; i<rows; i++){
        if(grid[i][j] >= max){
            max = grid[i][j];
            pos = i;
        }
    }
    check[pos][j] = max; // updated here
}

// UPDATE HERE
// these loops look for rows that have two 
// max values (one for a column and one for a row) that are equal
for(int j=0; j<rows; j++){
  max = 0;
  for(int i=0; i<columns; i++){
    if(check[j][i] != 0) {
      if (max == 0){
        max = check[j][i];
      }else if (max == check[j][i]){
        // reset
        check[j][i] = 0;
      }
    }
  }
}

int total = 0;
for(int i=0; i<rows; i++){
    for(int j=0; j<columns; j++){
        if(check[i][j]==0){ // updated here
            total += grid[i][j];
        }
    }
}
return total;
}