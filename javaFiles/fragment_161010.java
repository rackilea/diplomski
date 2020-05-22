Pieces[][] pzs = new Pieces[7][7];
//no need for int i, j
for(int i = 0; i < pzs.length; i++){     //pzs.length guarantees you won't get an 
    for(int j = 0; j < pzs[i].length; j++){ //ArrayIndexOutOfBoundsException even if pzs is something different
        pzs[i][j] = new Pieces();
        pzs[i][j].setSymbol('X')
    }
}