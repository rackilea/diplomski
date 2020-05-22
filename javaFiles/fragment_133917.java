int numberOfTwos = 0;
for(int r = 0; r < cavern.length; r++){
    for(int c = 0; c < cavern[r].length; c++){
        if(cavern[r][c] == 0){
           // We check that we're not on the last row, and also if the next             
           // row is also equals to 0
           if(r < cavern.length-1 && cavern[r+1][c]==0){
              numberOfTwos++;
              // We change both 0's to 2's
              cavern[r][c]=2
              cavern[r+1][c]=2;
           }
           // We also change if we're on a 2 and not on the last column
           else if(c < cavern[0].length-1 && cavern[r][c]==2){
              // if the next one is a 0, we change it for a 2
              if(cavern[r][c+1] ==0){
                 //numberOfTwos++;
                 cavern[r][c+1] =2;
              }
              // if the one under is also a 0, we change it for a 2
              else if(r < cavern.length-1 && cavern[r+1][c] ==0){
                 numberOfTwos++;
                 cavern[r+1][c] =2;
              }
           }
           // We only gonna change the current cavern[r][c] if there's no                                  
           //more rows to check
           else if(r == cavern.length-1){
              numberOfTwos++;
              cavern[r][c]=2;
           }
        }
    } 
}