if(i-j==row-col){ //diagonal up_left to down_right
        csp[i][j]=1;
  }

  if(i+j==row+col) { //diagonal down_left to up_right
        csp[i][j]=1;
  }