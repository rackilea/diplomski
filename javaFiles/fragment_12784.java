void right(){
    for(int i=0;i<56;i++){
        for(int k=0;k<56;k++){
            if(snakeHead[i][k] == 1 && i == 55){
                game = 0;
            } else if(snakeHead[i][k] == 1 && i != 55){
                snakeHead[i+1][k] = 1; // update the sankeHead to i+1 which will be reached in the next iteration in i so basiclly keep moving right till reach if block 
                snakeHead[i][k]=0;
            }
        } // end k loop
    } // end i loop
}