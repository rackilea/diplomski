field[][]
block[][]

isBlockBlocked(x,y){
    for each (a,b) in block {
        if( field[x+a][y+b] == 1 && block[a][b] == 1 ){
            return False;
        }
    }
    return True;
}