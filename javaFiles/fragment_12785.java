void right(){
    for(int i=0;i<56;i++){
        for(int k=0;k<56;k++){
            if(snakeHead[i][k] == 1 && i == 55){
                game = 0;
                return;
            } else if(snakeHead[i][k] == 1 && i != 55){
                snakeHead[i+1][k] = 1; 
                snakeHead[i][k]=0;
                return;
            }
        } // end k loop
    } // end i loop
}