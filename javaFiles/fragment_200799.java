if (dirDisp == 3){
            boolean foundObstacle = false;
            for(int x = 3, y = 0; x < 5 & y < 2; x++, y++){
                if(a[(a.length-1) - y][(a[x].length-1) / 2 + x] == EMPTY)
                   a[(a.length-1) - y][(a[x].length-1) / 2 + x] = '·';
                else {
                    foundObstacle = true;
                    break;
                }
            }
            if(!foundObstacle) {
                for(int x = 0, y = 1; x < 9 & y < 11; x++, y++){
                    if(a[(a.length-1) - y][(a[x].length-1) - x] == EMPTY)
                       a[(a.length-1) - y][(a[x].length-1) - x] = '·';
                    else {
                        foundObstacle = true;
                        break;
                    }
                }
            }
            if(!foundObstacle) {
                for(int x = 0, y = 9; x < 5 & y < 14; x++, y++){
                    if(a[(a.length-1) - y][x] == EMPTY)
                        a[(a.length-1) - y][x] = '·';
                    else break;
                }
            }
        }