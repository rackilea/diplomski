for(int x = currentPos.x; x < 7; x++){
            for(int y = 0; y < 7; y++){
                // check if Position is free and no free position has been found yet
                if(matrix[x][y] == 0 && stop == false){
                    stop = true;
                    System.out.println("OTHER X");
                    // set the position to x and y
                    currentPos.x = x;
                    currentPos.y = y;  
                }                
            }
        }  
        // display the NEXT POS (x,y)
        System.out.println("NEXT POS = ("+currentPos.x+";"+currentPos.y+")");       
    }