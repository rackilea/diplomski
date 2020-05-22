public static void shootDude (char [][] a , int shootDirection){
        START = ((RIGHT_WALL)/2) + shootDirection;
        boolean shotRight = false;
        if(shootDirection < 0)
            shotRight = false;
        else if(shootDirection > 0)
            shotRight = true;
        for(int x = BOTTOM,y = START ;x >= 0;x--) {
            if(!isOut(x,y) && !emptyCell(x,y)) break;
            if(y <= LEFT_WALL) 
                shotRight = true;
            if(y >= RIGHT_WALL) 
                shotRight = false;
            if(!isOut(x,y) && shotRight == true) {
                a[x][y] = SHOT;
                ++y;
            }
            if(!isOut(x,y) && shotRight == false){
                a[x][y] = SHOT;
                --y;
            }
        }
    }