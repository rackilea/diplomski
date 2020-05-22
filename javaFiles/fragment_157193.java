for(int i = 0; i < mat.length; i++) {
    for(int j = 0; j < mat[i].length; j++) {
       if(mat[i][j] == 1) {
          if(i < mat.length - 1 && mat[i+1][j] == 1) {
              count++;
          }
          if(j < mat[i].length - 1 && mat[i][j+1] == 1) {
              count++;
          }
    }
}