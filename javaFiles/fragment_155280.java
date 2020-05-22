for(int i = 0; i < 8; i++){
    int check = 0;
    for(int j = 0; j < 8; j++){             
        check += board[i][j]; 
    }
    if(check > 1){
        h += check - 1;
    }
}