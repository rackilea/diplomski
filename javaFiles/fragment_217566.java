public static void moveTo(char[][] tissue, int i, int j){    
    for(int k = 0; k < tissue.length; k++){
        for(int l=0; l<tissue[k].length; l++){
            if(tissue[k][l] == ' '){
                tissue[k][l] = tissue[i][j];
                tissue[i][j] = ' ';
                return;
            }
        }
    }
}