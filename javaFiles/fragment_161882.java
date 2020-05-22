boolean verify(int[][]m){
    for (int i = 0; i < m.length; i++) 
        for (int j = 0; j < m[i].length; j++) 
            if(i != j && m[i][j] == 0 && m[j][i] == 0) //there's the difference
                return false;
    return true;
}